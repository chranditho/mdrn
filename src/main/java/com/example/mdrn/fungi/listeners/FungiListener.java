package com.example.mdrn.fungi.listeners;

import com.example.mdrn.shared.events.DiseasedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public record FungiListener() {

    @EventListener
    public void onAnimalDiseased(DiseasedEvent event) {
        System.out.println("Fungi reacting to diseased animal: " + event.animalId());
        // Logic for fungi to "do their thing"
    }
}
