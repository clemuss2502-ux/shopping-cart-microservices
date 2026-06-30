package com.shoppingcart.order.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingcart.order.client.ProductClient;
import com.shoppingcart.order.dto.OrderRequest;
import com.shoppingcart.order.dto.OrderResponse;
import com.shoppingcart.order.dto.ProductDto;
import com.shoppingcart.order.entity.Order;
import com.shoppingcart.order.exception.ResourceNotFoundException;
import com.shoppingcart.order.repository.OrderRepository;
import com.shoppingcart.order.service.OrderService;
import com.shoppingcart.order.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final ProductClient productClient;
    private final OrderMapper orderMapper;
    
    public OrderServiceImpl(OrderRepository repository,
            ProductClient productClient,
            OrderMapper orderMapper) {

    	this.repository = repository;
    	this.productClient = productClient;
    	this.orderMapper = orderMapper;
    }

    @Override
    public OrderResponse createOrder(OrderRequest request) {

        ProductDto product =
                productClient.getProductById(request.getProductId());

        Order order = new Order();

        order.setProductId(request.getProductId());
        order.setQuantity(request.getQuantity());
        order.setUnitPrice(product.getPrice());

        order.setTotal(
                product.getPrice()
                        .multiply(
                                java.math.BigDecimal.valueOf(request.getQuantity())
                        )
        );

        order.setCreatedAt(LocalDateTime.now());

        Order savedOrder = repository.save(order);

        OrderResponse response = new OrderResponse();

        return orderMapper.toResponse(savedOrder);

    }
    
    @Override
    public List<OrderResponse> getOrders() {
    	return orderMapper.toResponseList(repository.findAll());
    }
    
    @Override
    public OrderResponse getOrderById(Long id) {

        Order order = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found"));
        
        OrderResponse response = new OrderResponse();
        
        return orderMapper.toResponse(order);
    }
    
    @Override
    public void deleteOrder(Long id) {

        if (!repository.existsById(id)) {
        	throw new ResourceNotFoundException("Order not found");
        }

        repository.deleteById(id);

    }

}