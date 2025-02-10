package com.example.mdrn.plants.adapters.out.persistence;

import com.example.mdrn.plants.domain.model.Plant;
import com.example.mdrn.plants.domain.ports.out.PlantRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class MockPlantRepository implements PlantRepository {
  @Override
  public List<Plant> findAll() {
    return List.of(
        new Plant(
            UUID.fromString("641ccca1-94c3-49cd-a35a-794ca7bd167d"),
            "Rose",
            "Rosa",
            LocalDate.of(2020, 5, 20)),
        new Plant(
            UUID.fromString("f6c6a896-99d3-4e26-8d14-1a10e669905f"),
            "Tulip",
            "Tulipa",
            LocalDate.of(2021, 3, 15)));
  }
}
