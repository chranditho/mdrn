package com.example.mdrn.animals.application;

import com.example.mdrn.animals.domain.model.Animal;
import com.example.mdrn.animals.ports.in.CarnivoresPort;
import com.example.mdrn.animals.ports.out.AnimalRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarnivoresUseCase implements CarnivoresPort {

  private final AnimalRepository animalRepository;

  @Override
  public List<Animal> getAllCarnivores() {
    return this.animalRepository.findAll().stream().filter(Animal::isCarnivorous).toList();
  }
}
