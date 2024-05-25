package com.gatheringability.order.service.data.access.restaurant.mapper;

import com.gatheringability.domain.valueobject.Money;
import com.gatheringability.domain.valueobject.ProductId;
import com.gatheringability.domain.valueobject.RestaurantId;
import com.gatheringability.order.service.data.access.restaurant.entity.RestaurantEntity;
import com.gatheringability.order.service.data.access.restaurant.exception.RestaurantDataAccessException;
import com.gatheringability.order.service.domain.entity.Product;
import com.gatheringability.order.service.domain.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RestaurantDataAccessMapper {

    public List<UUID> restaurantToRestaurantProducts(Restaurant restaurant) {
        return restaurant.getProducts().stream()
                .map(product -> product.getId().getValue())
                .collect(Collectors.toList());
    }

    public Restaurant restaurantEntityToRestaurant(List<RestaurantEntity> restaurantEntities) {
        RestaurantEntity restaurantEntity =
                restaurantEntities.stream().findFirst().orElseThrow(() ->
                        new RestaurantDataAccessException("Restaurant could not be found!"));

        List<Product> restaurantProducts = restaurantEntities.stream().map(entity ->
                new Product(new ProductId(entity.getProductId()), entity.getProductName(),
                        new Money(entity.getProductPrice()))
                ).collect(Collectors.toList());

        return Restaurant.builder()
                .restaurantId(new RestaurantId(restaurantEntity.getRestaurantId()))
                .products(restaurantProducts)
                .active(restaurantEntity.getRestaurantActive())
                .build();
    }
}
