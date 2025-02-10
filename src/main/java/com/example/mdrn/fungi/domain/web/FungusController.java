package com.example.mdrn.fungi.domain.web;

import com.example.mdrn.fungi.domain.ports.in.FungusPort;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fungi")
public class FungusController {

  private final FungusPort fungusPort;
  private final FungusMapper fungusMapper;

  public FungusController(FungusPort fungusPort, FungusMapper fungusMapper) {
    this.fungusPort = fungusPort;
    this.fungusMapper = fungusMapper;
  }

  @GetMapping("/poisonous")
  ResponseEntity<List<FungusDto>> getAllPoisonousFungi() {
    return ResponseEntity.ok(
        fungusPort.getAllPoisonousFungi().stream().map(fungusMapper::fungusToFungusDto).toList());
  }
}
