package com.gatheringability.order.service.data.access.order.adapter;

import com.gatheringability.order.service.data.access.order.mapper.OrderDataAccessMapper;
import com.gatheringability.order.service.data.access.order.respository.OrderJpaRepository;
import com.gatheringability.order.service.domain.entity.Order;
import com.gatheringability.order.service.domain.ports.output.repository.OrderRepository;
import com.gatheringability.order.service.domain.valueobject.TrackingId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderDataAccessMapper orderDataAccessMapper;

    public OrderRepositoryImpl(OrderJpaRepository orderJpaRepository, OrderDataAccessMapper orderDataAccessMapper) {
        this.orderJpaRepository = orderJpaRepository;
        this.orderDataAccessMapper = orderDataAccessMapper;
    }

    @Override
    public Order save(Order order) {
        // takes and returns domain object. translates to JPA entity so that it can be persisted.
        return orderDataAccessMapper.orderEntityToOrder(
                orderJpaRepository.save(orderDataAccessMapper.orderToOrderEntity(order)));
    }

    @Override
    public Optional<Order> findByTrackingId(TrackingId trackingId) {
        return orderJpaRepository.findByTrackingId(trackingId.getValue())
                .map(orderDataAccessMapper::orderEntityToOrder);
    }
}
