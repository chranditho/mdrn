package com.example.mdrn.plants.adapters.in.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plants")
public class PlantController {

  @GetMapping("/mature")
  public String getAllMaturePlants() {
    return "Hello, plants!";
  }
}
