package com.example.mdrn.animals.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class AnimalMockFactory {
  public static Animal createGrayWolf() {
    return new Animal(
        UUID.randomUUID(), "Gray Wolf", "Canis", "lupus", Diet.CARNIVORE, LocalDate.of(1758, 1, 1));
  }

  public static Animal createAfricanElephant() {
    return new Animal(
        UUID.randomUUID(),
        "African Elephant",
        "Loxodonta",
        "africana",
        Diet.HERBIVORE,
        LocalDate.of(1797, 1, 1));
  }

  public static Animal createBrownBear() {
    return new Animal(
        UUID.randomUUID(),
        "Brown Bear",
        "Ursus",
        "arctos",
        Diet.OMNIVORE,
        LocalDate.of(1758, 1, 1));
  }
}
