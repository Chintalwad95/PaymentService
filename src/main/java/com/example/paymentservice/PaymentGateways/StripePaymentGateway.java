package com.example.paymentservice.PaymentGateways;

import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentGateway{

    @Override
    public String generateLink(String orderId, String email, String phoneNumber, Long amount) {
        return null;
    }
}

