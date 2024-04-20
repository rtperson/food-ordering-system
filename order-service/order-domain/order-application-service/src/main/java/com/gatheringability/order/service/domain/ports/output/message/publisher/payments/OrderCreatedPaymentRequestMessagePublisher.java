package com.gatheringability.order.service.domain.ports.output.message.publisher.payments;

import com.gatheringability.domain.event.publisher.DomainEventPublisher;
import com.gatheringability.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {
}
