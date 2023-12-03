package com.example.paymentservice.Services;

import com.example.paymentservice.PaymentGateways.PaymentGateway;
import com.example.paymentservice.PaymentGateways.PaymentGatewayStrategychooser;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGatewayStrategychooser paymentGatewayStrategychooser;
    public PaymentService(PaymentGatewayStrategychooser paymentGatewayStrategychooser) {
        this.paymentGatewayStrategychooser = paymentGatewayStrategychooser;
    }
    public String initiatePayment(String orderId, String email, String phoneNumber, Long amount) {

        PaymentGateway paymentGateway = paymentGatewayStrategychooser.getBestPaymentGateway();
        return paymentGateway.generateLink(orderId,email,phoneNumber,amount);

    }
}
