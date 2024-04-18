package com.gatheringability.order.service.domain.ports.output.repository;

import com.gatheringability.order.service.domain.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {

    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
