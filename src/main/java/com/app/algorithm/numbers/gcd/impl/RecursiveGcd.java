package com.app.algorithm.numbers.gcd.impl;

import com.app.algorithm.numbers.gcd.Gcd;

/**
 * The RecursiveGcd class implements the Gcd interface to calculate the greatest common divisor using a recursive algorithm.
 */
public class RecursiveGcd implements Gcd {
    @Override
    public int nwd(int a, int b) {
        if (a != b) {
            return nwd(
                    a > b ? a - b : a,
                    b > a ? b - a : b
            );
        }
        return a;
    }
}
