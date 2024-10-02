package com.example.mdrn.plants.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public record Plant(UUID id, String name, String species, LocalDate plantedDate) {
  public boolean isMature() {
    return plantedDate.isBefore(LocalDate.now().minusYears(1));
  }
}
