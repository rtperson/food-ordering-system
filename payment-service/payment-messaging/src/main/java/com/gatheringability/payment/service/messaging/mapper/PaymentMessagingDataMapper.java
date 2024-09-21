package com.gatheringability.payment.service.messaging.mapper;

import com.gatheringability.domain.valueobject.PaymentOrderStatus;
import com.gatheringability.kafka.order.avro.model.PaymentRequestAvroModel;
import com.gatheringability.kafka.order.avro.model.PaymentResponseAvroModel;
import com.gatheringability.kafka.order.avro.model.PaymentStatus;
import com.gatheringability.payment.service.domain.dto.PaymentRequest;
import com.gatheringability.payment.service.domain.entity.Payment;
import com.gatheringability.payment.service.domain.event.PaymentCancelledEvent;
import com.gatheringability.payment.service.domain.event.PaymentCompletedEvent;
import com.gatheringability.payment.service.domain.event.PaymentFailedEvent;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class PaymentMessagingDataMapper {

    public PaymentResponseAvroModel paymentCompletedEventToPaymentResponseAvroModel(final PaymentCompletedEvent paymentCompletedEvent) {
        return setPaymentInfoOnAvroModel(paymentCompletedEvent.getPayment(),
                paymentCompletedEvent.getCreatedAt(),
                paymentCompletedEvent.getFailureMessages());
    }

    public PaymentResponseAvroModel paymentCancelledEventToPaymentResponseAvroModel(final PaymentCancelledEvent paymentCancelledEvent) {
        return setPaymentInfoOnAvroModel(paymentCancelledEvent.getPayment(),
                paymentCancelledEvent.getCreatedAt(),
                paymentCancelledEvent.getFailureMessages());
    }

    public PaymentResponseAvroModel paymentFailedEventToPaymentResponseAvroModel(final PaymentFailedEvent paymentFailedEvent) {
        return setPaymentInfoOnAvroModel(paymentFailedEvent.getPayment(),
                paymentFailedEvent.getCreatedAt(),
                paymentFailedEvent.getFailureMessages());
    }

    private PaymentResponseAvroModel setPaymentInfoOnAvroModel(final Payment payment,
                                                               ZonedDateTime createdAt,
                                                               List<String> failureMessages) {
        return PaymentResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId(UUID.fromString(""))
                .setPaymentId(payment.getId().getValue())
                .setCustomerId(payment.getCustomerId().getValue())
                .setOrderId(payment.getOrderId().getValue())
                .setPrice(payment.getPrice().getAmount())
                .setCreatedAt(createdAt.toInstant())
                .setPaymentStatus(PaymentStatus.valueOf(payment.getPaymentStatus().name()))
                .setFailureMessages(failureMessages)
                .build();
    }

    public PaymentRequest paymentRequestAvroModelToPaymentRequest(final PaymentRequestAvroModel paymentRequestAvroModel) {
        return PaymentRequest.builder()
                .id(paymentRequestAvroModel.getId().toString())
                .sagaId(paymentRequestAvroModel.getSagaId().toString())
                .customerId(paymentRequestAvroModel.getCustomerId().toString())
                .orderId(paymentRequestAvroModel.getOrderId().toString())
                .price(paymentRequestAvroModel.getPrice())
                .createdAt(paymentRequestAvroModel.getCreatedAt())
                .paymentOrderStatus(PaymentOrderStatus.valueOf(paymentRequestAvroModel.getPaymentOrderStatus().name()))
                .build();
    }
}
