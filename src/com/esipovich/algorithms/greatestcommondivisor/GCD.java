package com.esipovich.algorithms.greatestcommondivisor;

import java.util.Scanner;

/**
 * @author Artem Esipovich 29.03.2018
 *
 * 1) 1 <= a,b <= 2⋅10^9. Find greatest common divisor
 */

public class GCD {
    public static void main(String[] args) {
//        System.out.println(findGcdNaive(18, 27));
        System.out.println(readSourceData());
    }

    private static long readSourceData() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] numbers = line.split(" ");
        long n = Long.valueOf(numbers[0]);
        long m = Long.valueOf(numbers[1]);
        return findGcdOptimized(n, m);
    }


    public static long findGcdNaive(long a, long b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        long min = a > b ? b : a;

        long gcd = 1;
        for (long i = 2; i <= min; i++) {
            if ((a % i == 0) && (b % i == 0)) {
                gcd = i;
            }
        }
        return gcd;
    }

    private static long findGcdOptimized(long a, long b) {
        if (a == 0) {return b;}
        if (b == 0) {return a;}

        if (a > b) {
            return findGcdOptimized(a % b, b);
        } else {
            return findGcdOptimized(a, b % a);
        }
    }
}
