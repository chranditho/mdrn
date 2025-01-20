package com.example.mdrn.animals.adapters.in;

import com.example.mdrn.animals.domain.model.Animal;
import com.example.mdrn.animals.ports.in.HerbivoresPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/herbivores")
public class HerbivoresController {
  private final HerbivoresPort herbivoresPort;

  @GetMapping()
  public ResponseEntity<List<Animal>> getAllHerbivores() {
    return ResponseEntity.ok(herbivoresPort.getAllHerbivores());
  }
}
