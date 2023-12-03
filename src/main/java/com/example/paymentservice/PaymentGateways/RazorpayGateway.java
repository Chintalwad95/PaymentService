package com.example.paymentservice.PaymentGateways;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import lombok.Setter;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RazorpayGateway implements PaymentGateway{
    private RazorpayClient razorpayClient;

    public RazorpayGateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }


        @Override
        public String generateLink(String orderId, String email, String phoneNumber, Long amount) {
            try
            {

                JSONObject paymentLinkRequest = new JSONObject();
                paymentLinkRequest.put("amount",1000);
                paymentLinkRequest.put("currency","INR");
                paymentLinkRequest.put("accept_partial",true);
                paymentLinkRequest.put("first_min_partial_amount",100);
                paymentLinkRequest.put("expire_by",1701713616);
                paymentLinkRequest.put("reference_id","TS1989");
                paymentLinkRequest.put("description","Payment for policy no #23456");
                JSONObject customer = new JSONObject();
                customer.put("name","+919000090000");
                customer.put("contact","Shubham Chi");
                customer.put("email","gaurav.kumar@example.com");
                paymentLinkRequest.put("customer",customer);
                JSONObject notify = new JSONObject();
                notify.put("sms",true);
                notify.put("email",true);
                paymentLinkRequest.put("notify",notify);
                paymentLinkRequest.put("reminder_enable",true);
                JSONObject notes = new JSONObject();
                notes.put("policy_name","Jeevan Bima");
                paymentLinkRequest.put("notes",notes);
                paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
                paymentLinkRequest.put("callback_method","get");

                PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
                return payment.get("short_url").toString();
            }
            catch (Exception e)
            {
                // Handle Exception
                System.out.println(e.toString());
                return "Something is wrong";
            }
    }
}
