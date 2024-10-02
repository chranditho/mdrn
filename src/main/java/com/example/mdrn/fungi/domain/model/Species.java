package com.example.mdrn.fungi.domain.model;

public record Species(String value) {
  private static final int MAX_LENGTH = 256;

  public Species {
    if (value == null || value.isEmpty() || value.length() > MAX_LENGTH) {
      throw new IllegalArgumentException(
          "Species must be between 1 and %d characters.".formatted(MAX_LENGTH));
    }
  }

  static Result<Species> create(String value) {
    try {
      return Result.success(new Species(value));
    } catch (IllegalArgumentException e) {
      return Result.failure(e);
    }
  }
}
