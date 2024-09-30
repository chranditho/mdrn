package com.example.mdrn.fungi.domain.model;

import java.util.UUID;

public record Fungus(
        UUID id,
        Name name,
        Species species,
        DiscoveredDate discoveredDate,
        ToxicityLevel toxicityLevel) {

  public boolean isPoisonous() {
    return toxicityLevel.equals(ToxicityLevel.DEADLY)
           || toxicityLevel.equals(ToxicityLevel.POISONOUS);
  }
}