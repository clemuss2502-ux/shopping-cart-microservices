package com.shoppingcart.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shoppingcart.payment.dto.OrderDto;

@FeignClient(
        name = "order-service",
        url = "http://localhost:8082"
)
public interface OrderClient {

    @GetMapping("/orders/{id}")
    OrderDto getOrderById(@PathVariable Long id);

}