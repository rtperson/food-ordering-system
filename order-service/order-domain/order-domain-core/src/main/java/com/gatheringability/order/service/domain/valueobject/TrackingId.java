package com.gatheringability.order.service.domain.valueobject;

import com.gatheringability.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}
