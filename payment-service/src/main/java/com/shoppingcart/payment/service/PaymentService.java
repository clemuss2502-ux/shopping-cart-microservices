package com.shoppingcart.payment.service;

import java.util.List;

import com.shoppingcart.payment.dto.PaymentRequest;
import com.shoppingcart.payment.dto.PaymentResponse;

public interface PaymentService {

    PaymentResponse createPayment(PaymentRequest request);

    List<PaymentResponse> getPayments();

    PaymentResponse getPaymentById(Long id);

}