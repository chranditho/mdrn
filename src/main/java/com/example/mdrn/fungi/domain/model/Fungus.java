package com.example.mdrn.fungi.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public record Fungus(UUID id, String name, String species, LocalDate discoveredDate, ToxicityLevel toxicityLevel) {

    public boolean isPoisonous() {
        return toxicityLevel.poisonous();
    }
}
