package com.example.mdrn.animals.domain.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@RequiredArgsConstructor
class AnimalTest {

    private Animal panthera;

    @BeforeEach
    void setUp() {
        panthera = new Animal(UUID.fromString("192368ba-a293-4569-82d1-7df7b741a65b"), "Lion", "Panthera", "Panthera leo", Diet.CARNIVORE, LocalDate.of(2021, 9, 13));
      }

    @Test
    void isCarnivorous() {
        assertTrue(panthera.isCarnivorous());
      }

    @Test
    void isHerbivorous() {
        assertFalse(panthera.isHerbivorous());
      }

    @Test
    void isOmnivorous() {
        assertFalse(panthera.isOmnivorous());
      }
}