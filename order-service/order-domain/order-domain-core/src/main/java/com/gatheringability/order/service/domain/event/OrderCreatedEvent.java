package com.gatheringability.order.service.domain.event;

import com.gatheringability.domain.event.DomainEvent;
import com.gatheringability.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCreatedEvent extends OrderEvent {
    public OrderCreatedEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
