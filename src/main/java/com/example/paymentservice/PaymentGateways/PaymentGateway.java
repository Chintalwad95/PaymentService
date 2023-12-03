package com.example.paymentservice.PaymentGateways;

public interface PaymentGateway {
    public String generateLink(String orderId, String email, String phoneNumber, Long amount);
}
