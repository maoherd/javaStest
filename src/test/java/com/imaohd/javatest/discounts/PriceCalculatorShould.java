package com.imaohd.javatest.discounts;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorShould {

    @Test
    public void total_zero_when_there_are_prices() {

        PriceCalculator calculator = new PriceCalculator();

        assertEquals(0.0, calculator.getTotal(), 0.0);
    }

    @Test
    public void total_is_the_sum_of_prices() {
        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(10.2);
        calculator.addPrice(25.1);

        assertEquals(35.3, calculator.getTotal(), 0.0);
    }

    @Test
    public void apply_discount_to_prices() {
        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(8.5);
        calculator.addPrice(1.5);

        calculator.setDiscount(25);

        assertEquals(7.5, calculator.getTotal(), 0.0);
    }
}