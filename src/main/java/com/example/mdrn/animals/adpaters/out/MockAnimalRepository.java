package com.example.mdrn.animals.adpaters.out;

import static com.example.mdrn.animals.domain.model.AnimalMockFactory.*;

import com.example.mdrn.animals.domain.model.Animal;
import com.example.mdrn.animals.ports.out.AnimalRepository;
import java.util.List;

public class MockAnimalRepository implements AnimalRepository {
  @Override
  public List<Animal> findAll() {
    return List.of(createGrayWolf(), createAfricanElephant(), createBrownBear());
  }
}
