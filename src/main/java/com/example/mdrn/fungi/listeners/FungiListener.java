package com.example.mdrn.fungi.listeners;

import com.example.mdrn.shared.events.DeceasedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public record FungiListener() {

  @EventListener
  public void onAnimalDeceased(DeceasedEvent event) {
    System.out.println("Fungi reacting to diseased animal: " + event.animalId());
  }
}
