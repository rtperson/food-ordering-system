package com.gatheringability.payment.service.domain.valueobject;

import com.gatheringability.domain.valueobject.BaseId;

import java.util.UUID;

public class PaymentId extends BaseId<UUID> {
    public PaymentId(UUID value) {
        super(value);
    }
}
