package com.app.algorithm.numbers.fibonacci.impl;

import com.app.algorithm.numbers.fibonacci.Fibonacci;

/**
 * The FibonacciRec class implements the Fibonacci interface to generate Fibonacci numbers recursively.
 */
public class FibonacciRec implements Fibonacci {
    @Override
    public int getSequence(int idx) {
        if (idx < 3) {
            return 1;
        }
        return getSequence(idx - 1) + getSequence(idx - 2);
    }
}
