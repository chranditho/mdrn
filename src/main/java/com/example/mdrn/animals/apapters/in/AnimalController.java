package com.example.mdrn.animals.apapters.in;

import com.example.mdrn.animals.domain.model.Animal;
import com.example.mdrn.animals.ports.in.AnimalPort;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animals")
public class AnimalController {
  private final AnimalPort animalPort;

  public AnimalController(AnimalPort animalPort) {
    this.animalPort = animalPort;
  }

  @GetMapping("/herbivores")
  public ResponseEntity<List<Animal>> getAllHerbivores() {
    return ResponseEntity.ok(animalPort.getAllHerbivores());
  }
}
