package com.gatheringability.payment.service.domain.event;

import com.gatheringability.domain.event.publisher.DomainEventPublisher;
import com.gatheringability.payment.service.domain.entity.Payment;

import java.time.ZonedDateTime;
import java.util.Collections;

public class PaymentCancelledEvent extends PaymentEvent {

    private final DomainEventPublisher<PaymentCancelledEvent> paymentCancelledEventDomainEventPublisher;

    public PaymentCancelledEvent(Payment payment, ZonedDateTime createdAt,
                                 DomainEventPublisher<PaymentCancelledEvent> paymentCancelledEventDomainEventPublisher) {
        super(payment, createdAt, Collections.emptyList());
        this.paymentCancelledEventDomainEventPublisher = paymentCancelledEventDomainEventPublisher;
    }


    @Override
    public void fire() {
        paymentCancelledEventDomainEventPublisher.publish(this);
    }
}
