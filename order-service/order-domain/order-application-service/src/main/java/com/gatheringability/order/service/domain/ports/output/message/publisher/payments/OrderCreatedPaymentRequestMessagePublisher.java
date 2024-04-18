package com.gatheringability.order.service.domain.ports.output.message.publisher.payments;

import com.gatheringability.domain.event.DomainEvent;
import com.gatheringability.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEvent<OrderCreatedEvent> {
}
