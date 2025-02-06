package com.example.mdrn.shared.events;

import java.util.UUID;
import org.jmolecules.event.types.DomainEvent;

public record DeceasedEvent(UUID animalId) implements DomainEvent {}
