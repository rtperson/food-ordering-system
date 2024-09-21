package com.gatheringability.payment.service.dataaccess.creditentry.adapter;

import com.gatheringability.domain.valueobject.CustomerId;
import com.gatheringability.payment.service.dataaccess.creditentry.mapper.CreditEntryDataAccessMapper;
import com.gatheringability.payment.service.dataaccess.creditentry.repository.CreditEntryJpaRepository;
import com.gatheringability.payment.service.domain.entity.CreditEntry;
import com.gatheringability.payment.service.domain.ports.output.repository.CreditEntryRepository;

import java.util.Optional;

public class CreditEntryRepositoryImpl implements CreditEntryRepository {

    private final CreditEntryJpaRepository creditEntryJpaRepository;
    private final CreditEntryDataAccessMapper creditEntryDataAccessMapper;

    public CreditEntryRepositoryImpl(CreditEntryJpaRepository creditEntryJpaRepository,
                                     CreditEntryDataAccessMapper creditEntryDataAccessMapper) {
        this.creditEntryJpaRepository = creditEntryJpaRepository;
        this.creditEntryDataAccessMapper = creditEntryDataAccessMapper;
    }

    @Override
    public CreditEntry save(CreditEntry creditEntry) {
        return creditEntryDataAccessMapper.creditEntryEntityToCreditEntry(creditEntryJpaRepository
                .save(creditEntryDataAccessMapper.creditEntryToCreditEntryEntity(creditEntry)));
    }

    @Override
    public Optional<CreditEntry> findByCustomerId(CustomerId customerId) {
        return creditEntryJpaRepository
                .findByCustomerId(customerId.getValue())
                .map(creditEntryDataAccessMapper::creditEntryEntityToCreditEntry);
    }
}
