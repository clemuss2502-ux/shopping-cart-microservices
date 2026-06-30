package com.shoppingcart.product.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.shoppingcart.product.dto.ProductResponse;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "fakeStoreClient",
        url = "https://fakestoreapi.com"
)
public interface FakeStoreClient {

	@GetMapping("/products")
    List<ProductResponse> getProducts();

    @GetMapping("/products/{id}")
    ProductResponse getProductById(@PathVariable Long id);
}