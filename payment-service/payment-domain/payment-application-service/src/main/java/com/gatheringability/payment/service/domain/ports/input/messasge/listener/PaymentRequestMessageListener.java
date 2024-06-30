package com.gatheringability.payment.service.domain.ports.input.messasge.listener;

import com.gatheringability.payment.service.domain.dto.PaymentRequest;

public interface PaymentRequestMessageListener {

    void completePayment(PaymentRequest paymentRequest);

    void cancelPayment(PaymentRequest paymentRequest);
}
