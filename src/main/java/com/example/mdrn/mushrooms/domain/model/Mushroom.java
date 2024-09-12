package com.example.mdrn.mushrooms.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public record Mushroom(UUID id, String name, String species, LocalDate discoveredDate) {}
