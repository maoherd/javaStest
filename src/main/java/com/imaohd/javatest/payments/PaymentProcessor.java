package com.imaohd.javatest.payments;

public class PaymentProcessor {

    private final PaymentGateway paymentGateway;

    public PaymentProcessor(final PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount) {

        PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(amount));
        return response.getStatus() == PaymentResponse.PaymentStatus.OK;
    }
}
