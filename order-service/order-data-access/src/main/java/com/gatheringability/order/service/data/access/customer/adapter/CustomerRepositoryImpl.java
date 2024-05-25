package com.gatheringability.order.service.data.access.customer.adapter;

import com.gatheringability.order.service.data.access.customer.mapper.CustomerDataAccessMapper;
import com.gatheringability.order.service.data.access.customer.respository.CustomerJpaRepository;
import com.gatheringability.order.service.domain.entity.Customer;
import com.gatheringability.order.service.domain.ports.output.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerDataAccessMapper customerDataAccessMapper;

    public CustomerRepositoryImpl(final CustomerJpaRepository customerJpaRepository,
                                  final CustomerDataAccessMapper customerDataAccessMapper) {
        this.customerJpaRepository = customerJpaRepository;
        this.customerDataAccessMapper = customerDataAccessMapper;
    }

    @Override
    public Optional<Customer> findCustomer(UUID customerId) {
        return customerJpaRepository.findById(customerId).map(customerDataAccessMapper::customerEntityToCustomer);
    }
}
