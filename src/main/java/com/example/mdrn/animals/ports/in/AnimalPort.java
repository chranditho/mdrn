package com.example.mdrn.animals.ports.in;

import com.example.mdrn.animals.domain.model.Animal;
import java.util.List;

public interface AnimalPort {
  List<Animal> getAllHerbivores();
}
