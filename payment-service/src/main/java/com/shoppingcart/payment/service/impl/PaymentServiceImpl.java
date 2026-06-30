package com.shoppingcart.payment.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingcart.payment.client.OrderClient;
import com.shoppingcart.payment.dto.OrderDto;
import com.shoppingcart.payment.dto.PaymentRequest;
import com.shoppingcart.payment.dto.PaymentResponse;
import com.shoppingcart.payment.entity.Payment;
import com.shoppingcart.payment.exception.ResourceNotFoundException;
import com.shoppingcart.payment.mapper.PaymentMapper;
import com.shoppingcart.payment.repository.PaymentRepository;
import com.shoppingcart.payment.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final OrderClient orderClient;
    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentRepository repository,
                              OrderClient orderClient,
                              PaymentMapper paymentMapper) {

        this.repository = repository;
        this.orderClient = orderClient;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public PaymentResponse createPayment(PaymentRequest request) {

        // Obtener la orden desde order-service
        OrderDto order = orderClient.getOrderById(request.getOrderId());

        Payment payment = new Payment();

        payment.setOrderId(order.getId());
        payment.setAmount(order.getTotal());
        payment.setStatus("SUCCESS");
        payment.setPaymentDate(LocalDateTime.now());

        Payment saved = repository.save(payment);

        return paymentMapper.toResponse(saved);
    }

    @Override
    public List<PaymentResponse> getPayments() {

        return paymentMapper.toResponseList(repository.findAll());

    }

    @Override
    public PaymentResponse getPaymentById(Long id) {

        Payment payment = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Payment not found"));

        return paymentMapper.toResponse(payment);

    }

}