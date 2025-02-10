package com.example.mdrn.fungi.adapters.in.listeners;

import com.example.mdrn.shared.DeceasedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public record FungiListener() {

  @EventListener
  public void onAnimalDeceased(DeceasedEvent event) {
    System.out.println("Fungi reacting to diseased animal: " + event.animalId());
  }
}
