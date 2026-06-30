package com.shoppingcart.order.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.order.dto.OrderRequest;
import com.shoppingcart.order.dto.OrderResponse;
import com.shoppingcart.order.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
@Validated
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(@Valid @RequestBody OrderRequest request) {

        return orderService.createOrder(request);

    }
    
    @GetMapping
    public List<OrderResponse> getOrders() {

        return orderService.getOrders();

    }
    
    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id) {

        return orderService.getOrderById(id);

    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id) {

        orderService.deleteOrder(id);

    }
}