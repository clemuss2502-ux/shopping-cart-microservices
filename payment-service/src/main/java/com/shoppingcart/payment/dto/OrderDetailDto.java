package com.shoppingcart.payment.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderDetailDto {

    private Long id;

    private Long orderId;

    private Long productId;

    private Integer quantity;

    private BigDecimal unitPrice;

    private BigDecimal subtotal;

}