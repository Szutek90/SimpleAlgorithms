package com.app.algorithm.numbers.fibonacci.impl;

import com.app.algorithm.numbers.fibonacci.Fibonacci;

/**
 * The FibonacciIter class implements the Fibonacci interface to generate Fibonacci numbers iteratively.
 */
public class FibonacciIter implements Fibonacci {
    @Override
    public int getSequence(int idx) {
        if (idx < 3) {
            return 1;
        }
        var a = 1;
        var b = 1;
        var temp = 0;
        for (int i = 3; i <= idx; i++) {
            temp = b;
            b += a;
            a = temp;
        }
        return b;
    }
}
