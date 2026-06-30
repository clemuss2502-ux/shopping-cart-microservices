package com.shoppingcart.order.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.shoppingcart.order.dto.OrderResponse;
import com.shoppingcart.order.entity.Order;

@Component
public class OrderMapper {

    public OrderResponse toResponse(Order order) {

        OrderResponse response = new OrderResponse();

        response.setId(order.getId());
        response.setProductId(order.getProductId());
        response.setQuantity(order.getQuantity());
        response.setUnitPrice(order.getUnitPrice());
        response.setTotal(order.getTotal());
        response.setCreatedAt(order.getCreatedAt());

        return response;

    }

    public List<OrderResponse> toResponseList(List<Order> orders) {

        return orders.stream()
                .map(this::toResponse)
                .toList();

    }

}