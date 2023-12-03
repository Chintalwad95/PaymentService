package com.example.paymentservice.PaymentGateways;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayStrategychooser {

    private RazorpayGateway razorpayGateway;
    private StripePaymentGateway stripePaymentGateway;

    public PaymentGatewayStrategychooser(RazorpayGateway razorpayGateway, StripePaymentGateway stripePaymentGateway) {
        this.razorpayGateway = razorpayGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }
    public PaymentGateway getBestPaymentGateway() {

    return razorpayGateway;
    }
}
