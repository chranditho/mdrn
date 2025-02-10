package com.example.mdrn.fungi.domain.web;

import java.time.LocalDate;

public record FungusDto(
    String id,
    String name,
    String species,
    LocalDate discoveredDate,
    String toxicityLevel,
    boolean poisonous) {}
