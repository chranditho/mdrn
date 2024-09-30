package com.example.mdrn.fungi.domain.model;

// ToxicityLevel as a record using Lombok
import lombok.NonNull;
import lombok.With;

@With
public record ToxicityLevel(@NonNull String toxicityDescription, boolean poisonous) {}
