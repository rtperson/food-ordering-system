package com.gatheringability.payment.service.domain.ports.output.repository;

import com.gatheringability.domain.valueobject.CustomerId;
import com.gatheringability.payment.service.domain.entity.CreditEntry;

import java.util.Optional;

public interface CreditEntryRepository {

    CreditEntry save(CreditEntry creditEntry);

    Optional<CreditEntry> findByCustomerId(CustomerId customerId);
}
