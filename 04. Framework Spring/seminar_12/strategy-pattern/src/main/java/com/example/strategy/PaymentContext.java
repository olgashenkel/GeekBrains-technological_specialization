package com.example.strategy;

import org.springframework.stereotype.Component;

@Component
public class PaymentContext {

    private final CreditCardPayment creditCardPayment;
    private final PaypalPayment paypalPayment;

    public PaymentContext(CreditCardPayment creditCardPayment, PaypalPayment paypalPayment) {
        this.creditCardPayment = creditCardPayment;
        this.paypalPayment = paypalPayment;
    }

    public void executePayment(String method, double amount) {
        if ("CREDIT_CARD".equalsIgnoreCase(method)) {
            creditCardPayment.pay(amount);
        } else if ("PAYPAL".equalsIgnoreCase(method)) {
            paypalPayment.pay(amount);
        } else {
            throw new IllegalArgumentException("Unknown payment method: " + method);
        }
    }
}