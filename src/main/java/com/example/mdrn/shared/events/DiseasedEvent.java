package com.example.mdrn.shared.events;

import java.util.UUID;
import org.jmolecules.event.types.DomainEvent;

public record DiseasedEvent(UUID animalId) implements DomainEvent {}
