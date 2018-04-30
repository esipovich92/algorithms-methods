package com.esipovich.algorithms.fibonacci;

import com.esipovich.algorithms.helper.TrackableAlghorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Esipovich 4/30/2018
 */

public class FibonacciOptimized extends TrackableAlghorithm {

    private List<BigInteger> cache = new ArrayList<>();

    {
        cache.add(BigInteger.ZERO);
        cache.add(BigInteger.ONE);
    }

    @Override
    public void run() {
        System.out.println(fibonacci(100000));
    }

    private BigInteger fibonacci(int n) {
        //cache contains elements from 0 to cache.size-1
        //need to fill from cache.size to n
        for (int i = cache.size(); i <= n; i++) {
            BigInteger toInsert = cache.get(i - 1).add(cache.get(i - 2));
            cache.add(toInsert);
        }
        return cache.get(n);
    }

    public static void main(String[] args) {
        new FibonacciOptimized().runWithTrack();
    }
}
