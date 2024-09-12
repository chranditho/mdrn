package com.example.mdrn.plants.ports.out;

import com.example.mdrn.plants.domain.model.Plant;
import java.util.List;
import java.util.Optional;

public interface PlantRepository {
  Plant save(Plant plant);

  List<Plant> findAll();

  Optional<Plant> findById(Long id);
}
