package com.shoppingcart.product.service.impl;
import com.shoppingcart.product.mapper.ProductMapper;
import com.shoppingcart.product.dto.ProductDto;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingcart.product.client.FakeStoreClient;
import com.shoppingcart.product.dto.ProductDto;
import com.shoppingcart.product.mapper.ProductMapper;
import com.shoppingcart.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final FakeStoreClient fakeStoreClient;
    private final ProductMapper productMapper;
    

    public ProductServiceImpl(FakeStoreClient fakeStoreClient,
            ProductMapper productMapper) {

    	this.fakeStoreClient = fakeStoreClient;
    	this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getProducts() {
        return productMapper.toDtoList(fakeStoreClient.getProducts());
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productMapper.toDto(fakeStoreClient.getProductById(id));
    }
}