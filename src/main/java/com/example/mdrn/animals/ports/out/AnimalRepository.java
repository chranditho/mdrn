package com.example.mdrn.animals.ports.out;

import com.example.mdrn.animals.domain.model.Animal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository {
    List<Animal> findAll();
}
