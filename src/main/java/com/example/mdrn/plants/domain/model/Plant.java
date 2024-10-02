package com.example.mdrn.plants.domain.model;

import java.time.LocalDate;

public record Plant(Long id, String name, String species, LocalDate plantedDate) {
  public boolean isMature() {
    return plantedDate.isBefore(LocalDate.now().minusYears(1));
  }
}
