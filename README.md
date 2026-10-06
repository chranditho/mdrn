# mdrn

Spring Modulith showcase: hexagonal modules with enforced boundaries that talk to each other through domain events.

One Spring Boot application, split into modules that each keep their own domain, ports and adapters. The module boundaries and the hexagonal layering are checked by tests, so a dependency that crosses them fails the build instead of slipping into the code.

## What it demonstrates

- **Hexagonal modules.** Each module has a `domain` (model, use cases, ports) and `adapters` (REST controllers in, repositories and publishers out). Use cases implement the inbound ports and depend only on outbound ports, never on an adapter. (One exception: `fungi` keeps its controller in `domain/web` rather than `adapters/in`.)
- **Enforced boundaries.** Modules may not reach into each other's internals. The only shared code is the `shared` module, declared with `@Modulithic(sharedModules = "shared")`.
- **Communication through domain events.** `animals` publishes a `DeceasedEvent` (a jMolecules `DomainEvent`) through Spring's `ApplicationEventPublisher`; `fungi` listens for it. Neither module imports the other.

## Modules

All under `com.example.mdrn`:

| Module    | Responsibility                               | Endpoints                                         |
| --------- | -------------------------------------------- | ------------------------------------------------- |
| `animals` | Animals and their diet; publishes `DeceasedEvent` | `GET /herbivores`, `GET /carnivores`, `POST /carnivores/decease` |
| `plants`  | Plants and whether they are mature           | `GET /plants/mature`                              |
| `fungi`   | Fungi and their toxicity; reacts to `DeceasedEvent` | `GET /fungi/poisonous`                       |
| `shared`  | The `DeceasedEvent` record                   | none                                              |

Repositories are in-memory mocks, so there is no database to set up.

## How the boundaries are tested

- `MdrnApplicationTests.writeDocumentationSnippets` calls `ApplicationModules.of(MdrnApplication.class).verify()`, which fails on cycles between modules and on access to another module's internal types. It then writes PlantUML diagrams of the modules to `target/spring-modulith-docs/`.
- `MdrnApplicationTests.domainShouldNotDependOnAdapters` is an ArchUnit rule: nothing in a `..domain..` package may depend on a class in an `..adapters..` package.
- Each module has an `@ApplicationModuleTest`, which boots only that module (`AnimalIntegrationTest`, `PlantModuleIntegrationTest`, `FungusModuleIntegrationTest`). If a module secretly needed a bean from another one, its test would fail to start.

## Running it

Requires **JDK 22** (`java.version` in `pom.xml`). Newer JDKs don't work with the Lombok version pinned by Spring Boot 3.3.

Run the tests:

```sh
./mvnw test
```

Start the app on port 8080:

```sh
./mvnw spring-boot:run -Dspring-boot.run.arguments=--spring.docker.compose.enabled=false
```

The flag is needed because `spring-boot-docker-compose` is on the classpath and would otherwise try to start `compose.yaml` on boot, which requires a running Docker daemon.

Then trigger the domain event and watch the log for `Fungi reacting to diseased animal: <id>`:

```sh
curl -X POST localhost:8080/carnivores/decease
```

### Docker and Kubernetes

The `Dockerfile` packages the jar built by `./mvnw package`:

```sh
./mvnw package -DskipTests
docker build -t mdrn:latest .
docker run -p 8080:8080 mdrn:latest
```

`mdrn-deployment.yaml` and `mdrn-service.yaml` run that local `mdrn:latest` image (`imagePullPolicy: Never`) on a local cluster, exposed as a NodePort service:

```sh
kubectl apply -f mdrn-deployment.yaml -f mdrn-service.yaml
```

`compose.yaml` refers to an image `chranditho/mdrn-app` that isn't published, and maps port 8090 while the app listens on 8080, so use the commands above instead.

## Stack

Java 22, Spring Boot 3.3, Spring Modulith 1.2, jMolecules, ArchUnit, MapStruct, Lombok.
