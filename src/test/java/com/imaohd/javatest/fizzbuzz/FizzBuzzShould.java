package com.imaohd.javatest.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzShould {

    @Test
    public void return_Fizz_when_number_divisible_by_3() {

        assertEquals("Fizz", FizzBuzz.fizzbuzz(3));
    }

    @Test
    public void return_buzz_when_number_divisible_by_5() {

        assertEquals("Buzz", FizzBuzz.fizzbuzz(10));
    }

    @Test
    public void return_fizzbuzz_when_number_divisible_by_3_and_5() {
        assertEquals("FizzBuzz", FizzBuzz.fizzbuzz(15));
    }

    @Test
    public void return_number_when_not_divisible_by_3_or_5() {
        assertEquals("4", FizzBuzz.fizzbuzz(4));
    }
}