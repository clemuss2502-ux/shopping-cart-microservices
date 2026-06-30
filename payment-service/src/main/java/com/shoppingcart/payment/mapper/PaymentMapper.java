package com.shoppingcart.payment.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.shoppingcart.payment.dto.PaymentResponse;
import com.shoppingcart.payment.entity.Payment;

@Component
public class PaymentMapper {

    public PaymentResponse toResponse(Payment payment) {

        PaymentResponse response = new PaymentResponse();

        response.setId(payment.getId());
        response.setOrderId(payment.getOrderId());
        response.setAmount(payment.getAmount());
        response.setStatus(payment.getStatus());
        response.setPaymentDate(payment.getPaymentDate());

        return response;
    }

    public List<PaymentResponse> toResponseList(List<Payment> payments) {

        return payments.stream()
                .map(this::toResponse)
                .toList();
    }

}