package com.gatheringability.order.service.domain;

import com.gatheringability.order.service.domain.dto.track.TrackOrderQuery;
import com.gatheringability.order.service.domain.dto.track.TrackOrderResponse;
import com.gatheringability.order.service.domain.entity.Order;
import com.gatheringability.order.service.domain.exception.OrderNotFoundException;
import com.gatheringability.order.service.domain.mapper.OrderDataMapper;
import com.gatheringability.order.service.domain.ports.output.repository.OrderRepository;
import com.gatheringability.order.service.domain.valueobject.TrackingId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Slf4j
@Component
public class OrderTrackCommandHandler {

    private final OrderDataMapper orderDataMapper;

    private final OrderRepository orderRepository;

    public OrderTrackCommandHandler(OrderDataMapper orderDataMapper, OrderRepository orderRepository) {
        this.orderDataMapper = orderDataMapper;
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        Optional<Order> orderResult =  orderRepository.findByTrackingId(new TrackingId(trackOrderQuery.getOrderTrackingId()));

        if (orderResult.isEmpty()) {
            log.warn("Could not find order with trackingId {}", trackOrderQuery.getOrderTrackingId());
            throw new OrderNotFoundException("Could not find order with trackingId "
                    + trackOrderQuery.getOrderTrackingId());
        }
        return orderDataMapper.orderToTrackOrderResponse(orderResult.get());
    }
}
