package com.shoppingcart.product.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.shoppingcart.product.dto.ProductDto;
import com.shoppingcart.product.dto.ProductResponse;

@Component
public class ProductMapper {

    public ProductDto toDto(ProductResponse response) {

        ProductDto dto = new ProductDto();

        dto.setId(response.getId());
        dto.setTitle(response.getTitle());
        dto.setPrice(response.getPrice());
        dto.setCategory(response.getCategory());

        return dto;

    }

    public List<ProductDto> toDtoList(List<ProductResponse> responses) {

        return responses.stream()
                .map(this::toDto)
                .collect(Collectors.toList());

    }

}