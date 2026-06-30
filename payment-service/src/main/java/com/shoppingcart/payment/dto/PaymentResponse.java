package com.shoppingcart.payment.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PaymentResponse {

    private Long id;

    private Long orderId;

    private BigDecimal amount;

    private String status;

    private LocalDateTime paymentDate;

}