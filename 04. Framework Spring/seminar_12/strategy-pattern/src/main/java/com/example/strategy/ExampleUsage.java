package com.example.strategy;

import org.springframework.stereotype.Component;

@Component
public class ExampleUsage {

    private final PaymentContext paymentContext;

    public ExampleUsage(PaymentContext paymentContext) {
        this.paymentContext = paymentContext;
        performTask();
    }

    public void performTask() {
        paymentContext.executePayment("CREDIT_CARD", 100.0);
    }
}