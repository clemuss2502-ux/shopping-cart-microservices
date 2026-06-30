package com.shoppingcart.order.service;

import java.util.List;

import com.shoppingcart.order.dto.OrderRequest;
import com.shoppingcart.order.dto.OrderResponse;

public interface OrderService {

    OrderResponse createOrder(OrderRequest request);
    List<OrderResponse> getOrders();
    OrderResponse getOrderById(Long id);
    void deleteOrder(Long id);
}