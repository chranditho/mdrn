package com.example.mdrn.fungi.domain.model;


import java.time.LocalDate;
import java.util.UUID;

public class FungusMockFactory {

  public static Fungus createDeathCap() {
    Name name = Name.create("Death Cap").getValue();
    Species species = Species.create("Amanita phalloides").getValue();
    DiscoveredDate discoveredDate = DiscoveredDate.create(LocalDate.of(2022, 9, 13)).getValue();

    return new Fungus(
        UUID.fromString("123e4567-e89b-12d3-a456-426614174000"),
        name,
        species,
        discoveredDate,
        ToxicityLevel.DEADLY);
  }

  public static Fungus createShiitake() {
    Name name = Name.create("Shiitake").getValue();
    Species species = Species.create("Lentinula edodes").getValue();
    DiscoveredDate discoveredDate = DiscoveredDate.create(LocalDate.of(2021, 5, 20)).getValue();

    return new Fungus(
        UUID.fromString("223e4567-e89b-12d3-a456-426614174001"),
        name,
        species,
        discoveredDate,
        ToxicityLevel.EDIBLE);
  }
}
