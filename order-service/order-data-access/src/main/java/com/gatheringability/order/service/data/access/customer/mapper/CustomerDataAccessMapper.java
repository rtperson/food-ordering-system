package com.gatheringability.order.service.data.access.customer.mapper;

import com.gatheringability.domain.valueobject.CustomerId;
import com.gatheringability.order.service.data.access.customer.entity.CustomerEntity;
import com.gatheringability.order.service.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(final CustomerEntity customerEntity) {
        return new Customer(new CustomerId(customerEntity.getId()));
    }
}
