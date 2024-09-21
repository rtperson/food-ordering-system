package com.gatheringability.payment.service.domain;

import com.gatheringability.domain.event.publisher.DomainEventPublisher;
import com.gatheringability.payment.service.domain.entity.CreditEntry;
import com.gatheringability.payment.service.domain.entity.CreditHistory;
import com.gatheringability.payment.service.domain.entity.Payment;
import com.gatheringability.payment.service.domain.event.PaymentCancelledEvent;
import com.gatheringability.payment.service.domain.event.PaymentCompletedEvent;
import com.gatheringability.payment.service.domain.event.PaymentEvent;
import com.gatheringability.payment.service.domain.event.PaymentFailedEvent;

import java.util.List;

public interface PaymentDomainService {

    PaymentEvent validateAndInitiatePayment(Payment payment,
                                            CreditEntry creditEntry,
                                            List<CreditHistory> creditHistories,
                                            List<String> failureMessages,
                                            DomainEventPublisher<PaymentCompletedEvent> paymentCompletedEventPublisher,
                                            DomainEventPublisher<PaymentFailedEvent> paymentFailedEventDomainEventPublisher);

    PaymentEvent validateAndCancelPayment(Payment payment,
                                          CreditEntry creditEntry,
                                          List<CreditHistory> creditHistories,
                                          List<String> failureMessages,
                                          DomainEventPublisher<PaymentCancelledEvent> paymentCancelledEventDomainEventPublisher,
                                          DomainEventPublisher<PaymentFailedEvent> paymentFailedEventDomainEventPublisher);
}
