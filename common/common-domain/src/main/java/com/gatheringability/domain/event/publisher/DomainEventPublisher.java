package com.gatheringability.domain.event.publisher;

import com.gatheringability.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
