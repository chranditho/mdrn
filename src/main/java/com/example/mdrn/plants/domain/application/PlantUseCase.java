package com.example.mdrn.plants.domain.application;

import com.example.mdrn.plants.domain.model.Plant;
import com.example.mdrn.plants.domain.ports.in.PlantPort;
import com.example.mdrn.plants.domain.ports.out.PlantRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PlantUseCase implements PlantPort {

  private final PlantRepository plantRepository;

  public PlantUseCase(PlantRepository plantRepository) {
    this.plantRepository = plantRepository;
  }

  @Override
  public List<Plant> getAllMaturePlants() {
    List<Plant> plants = plantRepository.findAll();

    return plants.stream().filter(Plant::isMature).toList();
  }
}
