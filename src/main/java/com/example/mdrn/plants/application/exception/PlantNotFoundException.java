package com.example.mdrn.plants.application.exception;

public class PlantNotFoundException extends RuntimeException {
  public PlantNotFoundException(Long plantId) {
    super("Plant with ID " + plantId + " was not found.");
  }
}
