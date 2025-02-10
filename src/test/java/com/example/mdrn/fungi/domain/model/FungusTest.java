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
  void shouldBePoisonousIfToxicityLevelIsPoisonousOrDeadly(
      String name, String species, ToxicityLevel toxicityLevel) {
    Fungus toxicFungus =
        new Fungus(
            null,
            Name.create(name).getValue(),
            Species.create(species).getValue(),
            DiscoveredDate.create(LocalDate.now()).getValue(),
            toxicityLevel);

    assertTrue(toxicFungus.isPoisonous());
  }

  @Test
  void shouldBeNotPoisonousIfToxicityLevelsEdible() {
    Fungus edibleFungus =
        new Fungus(
            null,
            Name.create("Shiitake").getValue(),
            Species.create("Lentinula edodes").getValue(),
            DiscoveredDate.create(LocalDate.now()).getValue(),
            ToxicityLevel.EDIBLE);

    assertFalse(edibleFungus.isPoisonous());
  }
}
