package com.example.mdrn.plants.adapters.out.persistence;

import com.example.mdrn.plants.domain.model.Plant;
import com.example.mdrn.plants.ports.out.PlantRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MockPlantRepository implements PlantRepository {
  @Override
  public List<Plant> findAll() {
    return List.of(
        new Plant(1L, "Rose", "Rosa", LocalDate.of(2020, 5, 20)),
        new Plant(2L, "Tulip", "Tulipa", LocalDate.of(2021, 3, 15)));
  }
}
