package com.example.mdrn.fungi.domain.model;

public record Name(String value) {
  private static final int MAX_LENGTH = 256;

  public Name {
    if (value == null || value.isEmpty() || value.length() > MAX_LENGTH) {
      throw new IllegalArgumentException("Name must be between 1 and 256 characters.");
    }
  }

  static Result<Name> create(String value) {
    try {
      return Result.success(new Name(value));
    } catch (IllegalArgumentException e) {
      return Result.failure(e);
    }
  }
}
