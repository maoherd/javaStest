package com.imaohd.javatest.fizzbuzz;

public class FizzBuzz {

    public static String fizzbuzz(final int number) {

        if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("FizzBuzz");
            return "FizzBuzz";
        }

        if (number % 3 == 0) {
            System.out.println("Fizz");
            return "Fizz";
        }

        if (number % 5 == 0) {
            System.out.println("Buzz");
            return "Buzz";
        }
        System.out.println(number);
        return String.valueOf(number);
    }
}
