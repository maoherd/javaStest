package com.imaohd.javatest.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    private final List<Double> prices = new ArrayList<>();
    private double discount;

    public double getTotal() {

        return prices.stream().reduce(0.0, Double::sum) * ((100 - discount) / 100);
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(final double discount) {
        this.discount = discount;
    }
}
