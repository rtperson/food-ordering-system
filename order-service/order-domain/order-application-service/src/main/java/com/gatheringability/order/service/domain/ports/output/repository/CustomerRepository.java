package com.gatheringability.order.service.domain.ports.output.repository;

import com.gatheringability.order.service.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Optional<Customer> findCustomer(UUID customerId);
}
