package com.gatheringability.order.service.data.access.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_customer_m_view", schema="customer")
@Entity
public class CustomerEntity {

    private UUID id;
}
