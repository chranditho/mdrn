package com.example.mdrn.animals.domain.ports.in;

import com.example.mdrn.animals.domain.model.Animal;

import java.util.List;

public interface CarnivoresPort {
    List<Animal> getAllCarnivores();
}
