package com.app.algorithm.numbers;

import java.util.function.ToDoubleFunction;

/**
 * The ZeroFinderByBisection class provides a method for finding a zero of a function using the bisection method.
 */

public class ZeroFinderByBisection {
    private final double epsilon;

    /**
     * Constructs a ZeroFinderByBisection object with the specified precision.
     *
     * @param epsilon the precision for finding the zero
     */
    public ZeroFinderByBisection(double epsilon) {
        this.epsilon = epsilon;
    }

    /**
     * Finds a zero of the given function within the specified interval using the bisection method.
     *
     * @param function the function for which to find the zero
     * @param start    the lower bound of the interval
     * @param end      the upper bound of the interval
     * @return the approximate zero of the function within the interval
     * @throws IllegalArgumentException if the function has no zero within the interval or has multiple zeros
     */

    public double findZero(ToDoubleFunction<Double> function, double start, double end) {
        var a = function.applyAsDouble(start);
        if (a == 0) {
            return start;
        }
        var b = function.applyAsDouble(end);
        if (b == 0) {
            return end;
        }
        if (a * b > 0) {
            throw new IllegalArgumentException("There is no zero or has multiple zeros");
        }
        do {
            var zero = (start + end) / 2;
            var zeroValue = function.applyAsDouble(zero);
            if (zeroValue < epsilon) {
                return zero;
            }
            if (zeroValue * a < 0) {
                end = zero;
            }
            else {
                start = zero;
            }
        } while (Math.abs(start - end) > epsilon);

        return 0;
    }
}
