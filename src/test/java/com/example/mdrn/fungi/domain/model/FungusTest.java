package com.example.mdrn.fungi.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FungusTest {

  @ParameterizedTest
  @CsvSource({
    "Death Cap, Amanita phalloides, DEADLY",
    "Destroying Angel, Amanita virosa, POISONOUS"
  })
  void shouldBePoisonousIfToxicityLevelIsPoisonousOrDeadly(String name, String species, ToxicityLevel toxicityLevel) {
    Fungus fungus =
        new Fungus(
            null,
            new Name(name),
            new Species(species),
            new DiscoveredDate(LocalDate.now()),
            toxicityLevel);

    assertTrue(fungus.isPoisonous());
  }

  @Test
  void shouldBeNotPoisonousIfToxicityLevelsEdible() {
    Fungus edibleFungus =
        new Fungus(
            null,
            new Name("Shiitake"),
            new Species("Lentinula edodes"),
            new DiscoveredDate(LocalDate.now()),
            ToxicityLevel.EDIBLE);

    assertFalse(edibleFungus.isPoisonous());
  }
}
