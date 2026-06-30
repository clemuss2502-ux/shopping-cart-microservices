package com.shoppingcart.order.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderResponse {

    private Long id;

    private Long productId;

    private Integer quantity;

    private BigDecimal unitPrice;

    private BigDecimal total;

    private LocalDateTime createdAt;

}