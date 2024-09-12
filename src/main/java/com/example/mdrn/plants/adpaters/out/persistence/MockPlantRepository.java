package com.example.mdrn.plants.adpaters.out.persistence;

import com.example.mdrn.plants.domain.model.Plant;
import com.example.mdrn.plants.ports.out.PlantRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MockPlantRepository implements PlantRepository {
  @Override
  public Plant save(Plant plant) {
    return null;
  }

  @Override
  public List<Plant> findAll() {
    return List.of(
        new Plant(1L, "Rose", "Rosa", LocalDate.of(2020, 5, 20)),
        new Plant(2L, "Tulip", "Tulipa", LocalDate.of(2021, 3, 15)));
  }

  @Override
  public Optional<Plant> findById(Long id) {
    return Optional.empty();
  }
}
