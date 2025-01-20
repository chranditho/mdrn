package com.example.mdrn.animals.adapters.out;

import static com.example.mdrn.animals.domain.model.AnimalMockFactory.*;

import com.example.mdrn.animals.domain.model.Animal;
import com.example.mdrn.animals.ports.out.AnimalRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MockAnimalRepository implements AnimalRepository {
  @Override
  public List<Animal> findAll() {
    return List.of(createGrayWolf(), createAfricanElephant(), createBrownBear());
  }
}
