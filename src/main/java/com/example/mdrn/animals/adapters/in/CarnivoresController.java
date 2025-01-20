package com.example.mdrn.animals.adapters.in;

import com.example.mdrn.animals.application.CarnivoresUseCase;
import com.example.mdrn.animals.domain.model.Animal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/carnivores")
public class CarnivoresController {

  private final CarnivoresUseCase carnivoresUseCase;

  @GetMapping()
  public ResponseEntity<List<Animal>> getAllCarnivores() {
    return ResponseEntity.ok(this.carnivoresUseCase.getAllCarnivores());
  }
}
