package com.esipovich.algorithms.fibonacci;

import com.esipovich.algorithms.helper.TrackableAlghorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Artem Esipovich 21.03.2018
 *
 * 1) Integer 1 <= n <= 40. Need to find a value at the position n (using stdin and stdout)
 * 2) Integer 1 <= n <= 10^7. Need to find last digit of the n-number (using stdin and stdout)
 * 3) Integers 1 <= n <= 10^18 and 2 <= m <= 10^5. Find a rest of Fn/m
 */

public class Fibonacci extends TrackableAlghorithm {

    public static void main(String[] args) {
        new Fibonacci().trackTime();
    }

    @Override
    public void run() {
        System.out.println(findNumberOptimized(10));
//        System.out.println(findLastDigit(getN(1, (int) Math.pow(10.0, 7.0))));
//        System.out.println(readSourceData());
    }

    private static int readNumber(int first, int last) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            n = scanner.nextInt();
        } while (n < first || n > last);

        return n;
    }

    private static long readSourceData() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] numbers = line.split(" ");
        long n = Long.valueOf(numbers[0]);
        long m = Long.valueOf(numbers[1]);
        return findModule(n, m);
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

    private static long findLastDigit(int index) {
        if (index <= 2){
            return 1;
        }
        int currentLastDigit = 1;
        int nextLastDigit = 2;
        int tempLastDigit;
        for (int i = 3; i < index; i++) {
            tempLastDigit = nextLastDigit;
            nextLastDigit = (currentLastDigit + nextLastDigit) % 10;
            currentLastDigit = tempLastDigit;
        }
        return nextLastDigit;
    }

    private static long findModule(long n, long m) {
        if (n == 0 || n == 1) {
            return n;
        }

        List<Long> pizanoPeriod = new ArrayList<>();
        pizanoPeriod.add(0L);
        pizanoPeriod.add(1L);

        for (int i = 2; i < m * 6; i++) {
            pizanoPeriod.add((pizanoPeriod.get(i - 1) + pizanoPeriod.get(i - 2)) % m);

            if (pizanoPeriod.get(i) == 1 && pizanoPeriod.get(i - 1) == 0) {
                break;
            }
        }

        int indexOfPizanoElement = (int) (n % (pizanoPeriod.size() - 2));

        return pizanoPeriod.get(indexOfPizanoElement);
    }
}
