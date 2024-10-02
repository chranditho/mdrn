package com.example.mdrn.plants.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class PlantTest {

  @Test
  void shouldBeImmatureIfPlantAgeIsLessThanOneYear() {
    Plant plant = new Plant(UUID.randomUUID(), "Rose", "Rosa", LocalDate.now().minusMonths(11));
    assertFalse(plant.isMature());
  }

  @Test
  void shouldBeMatureIfPlantAgeIsMoreThanOneYear() {
    Plant plant =
        new Plant(UUID.randomUUID(), "Rose", "Rosa", LocalDate.now().minusYears(1).minusDays(1));
    assertTrue(plant.isMature());
  }
}
