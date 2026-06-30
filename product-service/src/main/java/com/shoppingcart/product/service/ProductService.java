package com.shoppingcart.product.service;

import java.util.List;

import com.shoppingcart.product.dto.ProductDto;

public interface ProductService {

    List<ProductDto> getProducts();

    ProductDto getProductById(Long id);

}