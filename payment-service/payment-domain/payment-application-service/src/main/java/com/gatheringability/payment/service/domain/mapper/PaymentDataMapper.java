package com.gatheringability.payment.service.domain.mapper;

import com.gatheringability.domain.valueobject.CustomerId;
import com.gatheringability.domain.valueobject.Money;
import com.gatheringability.domain.valueobject.OrderId;
import com.gatheringability.payment.service.domain.dto.PaymentRequest;
import com.gatheringability.payment.service.domain.entity.Payment;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PaymentDataMapper {

    public Payment paymentRequestModelToPayment(PaymentRequest paymentRequest) {
        return Payment.builder()
                .orderId(new OrderId(UUID.fromString(paymentRequest.getOrderId())))
                .customerId(new CustomerId(UUID.fromString(paymentRequest.getCustomerId())))
                .price(new Money(paymentRequest.getPrice()))
                .build();
    }
}
