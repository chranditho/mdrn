package com.example.mdrn.animals.ports.out;

import com.example.mdrn.animals.domain.model.Animal;
import java.util.List;

public interface AnimalRepository {
    List<Animal> findAll();
}
