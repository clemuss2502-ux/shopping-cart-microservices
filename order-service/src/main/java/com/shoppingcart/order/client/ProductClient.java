package com.shoppingcart.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shoppingcart.order.dto.ProductDto;

@FeignClient(
        name = "product-service",
        url = "http://localhost:8081"
)
public interface ProductClient {

    @GetMapping("/products/{id}")
    ProductDto getProductById(@PathVariable Long id);

}