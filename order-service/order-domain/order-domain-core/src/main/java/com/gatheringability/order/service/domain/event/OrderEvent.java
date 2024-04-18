package com.gatheringability.order.service.domain.event;

import com.gatheringability.domain.event.DomainEvent;
import com.gatheringability.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public abstract class OrderEvent implements DomainEvent<Order>{
    private final Order order;
    private final ZonedDateTime createdAt;

    public OrderEvent(final Order order, final ZonedDateTime createdAt) {
        this.order = order;
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return order;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
