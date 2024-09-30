package com.example.mdrn.fungi.adapters.in.web;

import com.example.mdrn.fungi.domain.model.Fungus;
import com.example.mdrn.fungi.ports.in.FungusPort;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fungi")
public class FungusController {

  private final FungusPort fungusPort;

  public FungusController(FungusPort fungusPort) {
    this.fungusPort = fungusPort;
  }

  @GetMapping("/poisonous")
  public ResponseEntity<List<Fungus>> getAllPoisonousFungi() {
    return ResponseEntity.ok(fungusPort.getAllPoisonousFungi());
  }
}
