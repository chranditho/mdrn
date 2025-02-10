package com.example.mdrn.animals.domain.application;

import com.example.mdrn.animals.domain.model.Animal;
import com.example.mdrn.animals.domain.ports.in.HerbivoresPort;
import com.example.mdrn.animals.domain.ports.out.AnimalRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HerbivoresUseCase implements HerbivoresPort {

  private final AnimalRepository animalRepository;

  @Override
  public List<Animal> getAllHerbivores() {
    return this.animalRepository.findAll().stream().filter(Animal::isHerbivorous).toList();
  }
}
