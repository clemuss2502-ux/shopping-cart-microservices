package com.shoppingcart.payment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.shoppingcart.payment.dto.PaymentRequest;
import com.shoppingcart.payment.dto.PaymentResponse;
import com.shoppingcart.payment.service.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse createPayment(
            @Valid @RequestBody PaymentRequest request) {

        return paymentService.createPayment(request);
    }

    @GetMapping
    public List<PaymentResponse> getPayments() {

        return paymentService.getPayments();

    }

    @GetMapping("/{id}")
    public PaymentResponse getPaymentById(@PathVariable Long id) {

        return paymentService.getPaymentById(id);

    }

}