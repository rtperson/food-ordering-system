package com.gatheringability.order.service.domain.entity;

import com.gatheringability.domain.entity.AggregateRoot;
import com.gatheringability.domain.valueobject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {

    public Customer() {

    }
    public Customer(CustomerId customerId) {
        super.setId(customerId);
    }
}
