package com.example.mdrn.plants.ports.in;

import com.example.mdrn.plants.domain.model.Plant;
import java.util.List;

public interface PlantPort {

  List<Plant> getAllMaturePlants();
}
