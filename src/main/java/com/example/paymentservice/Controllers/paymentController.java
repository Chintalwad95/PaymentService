package com.example.paymentservice.Controllers;

import com.example.paymentservice.Services.PaymentService;
import com.example.paymentservice.dtos.InitiatePaymentDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class paymentController {

    private PaymentService paymentService;
    public paymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @RequestMapping("/")
    public String intiatePayment(@RequestBody InitiatePaymentDTO request) {
        return paymentService.initiatePayment(request.getOrderId(), request.getEmail(), request.getPhoneNumber(), request.getAmount());
    }
}
