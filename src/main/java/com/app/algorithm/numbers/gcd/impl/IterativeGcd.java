package com.app.algorithm.numbers.gcd.impl;

import com.app.algorithm.numbers.gcd.Gcd;

/**
 * The IterativeGcd class implements the Gcd interface to calculate the greatest common divisor using an iterative algorithm.
 */
public class IterativeGcd implements Gcd {
    @Override
    public int nwd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
}
