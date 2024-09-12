package com.example.mdrn.plants.adapters.in.web;

import com.example.mdrn.plants.domain.model.Plant;
import com.example.mdrn.plants.ports.in.PlantPort;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plants")
public class PlantController {

  private final PlantPort plantPort;

  public PlantController(PlantPort plantPort) {
    this.plantPort = plantPort;
  }

  @GetMapping("/mature")
  public ResponseEntity<List<Plant>> getAllMaturePlants() {
    return new ResponseEntity<>(plantPort.getAllMaturePlants(), HttpStatus.OK);
  }
}
