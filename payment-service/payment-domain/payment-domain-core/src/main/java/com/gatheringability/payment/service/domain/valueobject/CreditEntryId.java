package com.gatheringability.payment.service.domain.valueobject;

import com.gatheringability.domain.valueobject.BaseId;

import java.util.UUID;

public class CreditEntryId extends BaseId<UUID> {

    public CreditEntryId(UUID value) {
        super(value);
    }
}
