package com.esipovich.algorithms.fibonacci;

/**
 * @author Artem Esipovich 21.03.2018
 */

public class Main {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        long number = fibonacci.findNumber(5, true);
        System.out.println("The number is: " + number);
    }
}
