package com.example.mdrn.fungi.domain.model;

import lombok.Getter;

@Getter
class Result<T> {
  private final T value;
  private final Throwable error;

  private Result(T value, Throwable error) {
    this.value = value;
    this.error = error;
  }

  public static <T> Result<T> success(T value) {
    return new Result<>(value, null);
  }

  public static <T> Result<T> failure(Throwable error) {
    return new Result<>(null, error);
  }
}
