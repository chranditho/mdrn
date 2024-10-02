package com.example.mdrn.plants.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class PlantTest {

  @Test
  void shouldBeImmatureIfPlantAgeIsLessThanOneYear() {
    LocalDate lessThanOneYear = LocalDate.now().minusMonths(11);
    Plant plant = new Plant(null, "", "", lessThanOneYear);
    assertFalse(plant.isMature());
  }

  @Test
  void shouldBeMatureIfPlantAgeIsMoreThanOneYear() {
    LocalDate moreThanOneYear = LocalDate.now().minusYears(1).minusDays(1);
    Plant plant = new Plant(null, "", "", moreThanOneYear);
    assertTrue(plant.isMature());
  }
}
