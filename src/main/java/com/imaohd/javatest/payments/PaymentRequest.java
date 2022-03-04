package com.imaohd.javatest.payments;

public class PaymentRequest {

    private final double amount;

    public PaymentRequest(final double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
