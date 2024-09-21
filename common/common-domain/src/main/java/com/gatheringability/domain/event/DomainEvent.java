package com.gatheringability.domain.event;

public interface DomainEvent<T> {
    void fire();
}
