package com.example.mdrn.plants.domain.model.domain;

public class PlantNotFoundException extends RuntimeException {
  public PlantNotFoundException(Long plantId) {
    super("Plant with ID " + plantId + " was not found.");
  }
}
