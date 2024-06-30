package com.gatheringability.payment.service.domain.ports.output.message.publisher;

import com.gatheringability.domain.event.publisher.DomainEventPublisher;
import com.gatheringability.payment.service.domain.event.PaymentCancelledEvent;

public interface PaymentCancelledMessagePublisher extends DomainEventPublisher<PaymentCancelledEvent> {
}
