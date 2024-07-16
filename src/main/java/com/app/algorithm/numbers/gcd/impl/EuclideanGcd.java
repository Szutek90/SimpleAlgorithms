package com.app.algorithm.numbers.gcd.impl;

import com.app.algorithm.numbers.gcd.Gcd;

/**
 * The EuclideanGcd class implements the Gcd interface to calculate the greatest common divisor using the Euclidean algorithm.
 */
public class EuclideanGcd implements Gcd {
    @Override
    public int nwd(int a, int b) {
        while (b != 0) {
            var modulo = a % b;
            a = b;
            b = modulo;
        }
        return a;
    }
}
