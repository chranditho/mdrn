package com.example.mdrn.shared;

import java.util.UUID;
import org.jmolecules.event.types.DomainEvent;

public record DeceasedEvent(UUID animalId) implements DomainEvent {}
