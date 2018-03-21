package com.esipovich.algorithms.fibonacci;

/**
 * @author Artem Esipovich 21.03.2018
 */

public class Fibonacci {

    public long findNumber(int index, boolean naive) {
        long startTime = System.currentTimeMillis();
        long number = 0;
        if (naive) {
            number = findNumberNaive(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.print("Time elapsed: " + (endTime - startTime) + " ms. ");
        return number;
    }

    private long findNumberNaive(int index) {
        if (index <= 1) {
            return index;
        } else {
            return findNumberNaive(index - 1) + findNumberNaive(index - 2);
        }
    }

}
