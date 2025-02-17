package com.example.mdrn.plants.domain.application.exception;

import java.util.UUID;

public class PlantNotFoundException extends RuntimeException {
  public PlantNotFoundException(UUID plantId) {
    super("Plant with ID " + plantId + " was not found.");
  }
}
