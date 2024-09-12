package com.example.mdrn.plants.application;

import com.example.mdrn.plants.domain.model.Plant;
import com.example.mdrn.plants.ports.in.PlantPort;
import com.example.mdrn.plants.ports.out.PlantRepository;
import java.util.List;
import java.util.stream.Collectors;

public class PlantUseCase implements PlantPort {

    private final PlantRepository plantRepository;

    public PlantUseCase(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    public List<Plant> getAllMaturePlants() {
        // Fetch all plants from the repository
        List<Plant> plants = plantRepository.findAll();

        // Filter mature plants based on domain logic
        return plants.stream()
                .filter(Plant::isMature)
                .collect(Collectors.toList());
    }
    }
