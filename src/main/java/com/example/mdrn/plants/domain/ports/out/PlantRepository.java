package com.example.mdrn.plants.domain.ports.out;

import com.example.mdrn.plants.domain.model.Plant;
import java.util.List;

public interface PlantRepository {
  List<Plant> findAll();
}
