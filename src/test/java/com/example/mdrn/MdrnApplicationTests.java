package com.example.mdrn;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class MdrnApplicationTests {

  @Test
  void writeDocumentationSnippets() {

    var modules = ApplicationModules.of(MdrnApplication.class).verify();

    new Documenter(modules).writeModulesAsPlantUml().writeIndividualModulesAsPlantUml();
  }

  private final JavaClasses importedClasses =
      new ClassFileImporter().importPackages("com.example.mdrn");

  @Test
  void domainShouldNotDependOnAdapters() {
    ArchRule rule =
        ArchRuleDefinition.noClasses()
            .that()
            .resideInAPackage("..domain..") // Domain layer
            .should()
            .dependOnClassesThat()
            .resideInAPackage("..adapters.."); // Adapters layer

    rule.check(importedClasses);
  }
}
