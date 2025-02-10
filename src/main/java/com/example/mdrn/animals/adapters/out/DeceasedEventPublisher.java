package com.example.mdrn.animals.adapters.out;

import com.example.mdrn.shared.DeceasedEvent;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeceasedEventPublisher {
  private final @NonNull ApplicationEventPublisher events;

  @Transactional
  public void unalife() {
    events.publishEvent(new DeceasedEvent(UUID.randomUUID()));
  }
}
