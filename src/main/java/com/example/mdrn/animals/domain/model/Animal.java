package com.example.mdrn.animals.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public record Animal(
    UUID id, String name, String genus, String species, Diet diet, LocalDate discoveredDate) {

  public boolean isCarnivorous() {
    return Diet.CARNIVORE.equals(this.diet);
  }

  public boolean isHerbivorous() {
    return Diet.HERBIVORE.equals(this.diet);
  }

  public boolean isOmnivorous() {
    return Diet.OMNIVORE.equals(this.diet);
  }

  public String scientificName() {
    return "%s %s".formatted(this.genus, this.species);
  }
}
