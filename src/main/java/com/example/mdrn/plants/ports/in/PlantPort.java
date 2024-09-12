package com.example.mdrn.plants.ports.in;

import com.example.mdrn.plants.domain.model.Plant;
import java.time.LocalDate;
import java.util.List;

public interface PlantPort {
  Plant registerNewPlant(String name, String species, LocalDate plantedDate);

  List<Plant> getAllPlants();
}
