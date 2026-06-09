package com.example.strategy;

import org.springframework.stereotype.Component;

@Component
public class PaypalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid with PayPal: $" + amount);
    }
}