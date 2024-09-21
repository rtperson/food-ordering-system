package com.gatheringability.payment.service.domain.event;

import com.gatheringability.domain.event.DomainEvent;
import com.gatheringability.domain.event.publisher.DomainEventPublisher;
import com.gatheringability.payment.service.domain.entity.Payment;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

public class PaymentCompletedEvent extends PaymentEvent {

    private final DomainEventPublisher<PaymentCompletedEvent> paymentCompletedEventPublisher;

    public PaymentCompletedEvent(Payment payment,
                                 ZonedDateTime createdAt,
                                 DomainEventPublisher<PaymentCompletedEvent> paymentCompletedEventPublisher) {
        super(payment, createdAt, Collections.emptyList());
        this.paymentCompletedEventPublisher = paymentCompletedEventPublisher;
    }

    @Override
    public void fire() {
        paymentCompletedEventPublisher.publish(this);
    }
}
