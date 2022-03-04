package com.imaohd.javatest.payments;

public class PaymentResponse {

    private final PaymentStatus status;

    public PaymentResponse(final PaymentStatus status) {
        this.status = status;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    enum PaymentStatus {
        OK, ERROR
    }
}
