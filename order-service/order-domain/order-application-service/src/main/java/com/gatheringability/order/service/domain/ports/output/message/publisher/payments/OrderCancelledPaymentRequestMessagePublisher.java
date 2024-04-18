package com.gatheringability.order.service.domain.ports.output.message.publisher.payments;

import com.gatheringability.domain.event.publisher.DomainEventPublisher;
import com.gatheringability.order.service.domain.event.OrderCancelledEvent;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
