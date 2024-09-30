package com.example.mdrn.fungi.domain.model;

import java.time.LocalDate;

public record DiscoveredDate(LocalDate value) {
    public DiscoveredDate {
        if (value == null || value.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Discovered date cannot be in the future.");
        }
    }

    static Result<DiscoveredDate> create(LocalDate value) {
        try {
            return Result.success(new DiscoveredDate(value));
        } catch (IllegalArgumentException e) {
            return Result.failure(e);
        }
    }
}