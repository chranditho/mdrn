package com.example.mdrn.animals.publishers;

import com.example.mdrn.shared.events.DeceasedEvent;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeceasedEventPublisher {
    private final @NonNull ApplicationEventPublisher events;

    @Transactional
    public void unalife() {
    events.publishEvent(new DeceasedEvent(UUID.randomUUID()));
    }
}
