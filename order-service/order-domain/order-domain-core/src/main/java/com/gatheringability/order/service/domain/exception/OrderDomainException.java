package com.gatheringability.order.service.domain.exception;

import com.gatheringability.domain.exception.DomainException;

public class OrderDomainException extends DomainException {
    public OrderDomainException(final String message) {
        super(message);
    }

    public OrderDomainException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
