package com.esipovich.algorithms.fibonacci;

import java.util.Scanner;

/**
 * @author Artem Esipovich 21.03.2018
 *
 * Integer 1 <= n <= 40. Need to find a value at the position n (using stdin and stdout)
 */

public class Fibonacci {

    public static void main(String[] args) {
        readNumber();
    }

    private static void readNumber() {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            n = scanner.nextInt();
        } while (n < 1 || n > 40);

        System.out.print(findNumberOptimized(n));

    }

    private long findNumberNaive(int index) {
        if (index <= 2) {
            return 1;
        } else {
            return findNumberNaive(index - 1) + findNumberNaive(index - 2);
        }
    }

    private static long findNumberOptimized(int index) {
        int fibonacci[] = new int[index];
        if (index <= 1){
            return 1;
        }
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 2; i < index; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        return fibonacci[index-1];
    }

}
