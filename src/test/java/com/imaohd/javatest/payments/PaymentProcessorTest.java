package com.imaohd.javatest.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PaymentProcessorTest {

    private PaymentGateway mockPaymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before
    public void setup() {

        mockPaymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(mockPaymentGateway);
    }

    @Test
    public void payment_is_correct() {

        Mockito.when(mockPaymentGateway.requestPayment(Mockito.any()))
            .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void payment_is_wrong() {

        Mockito.when(mockPaymentGateway.requestPayment(Mockito.any()))
            .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        assertFalse(paymentProcessor.makePayment(1000));
    }
}