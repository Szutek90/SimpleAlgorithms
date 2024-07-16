package com.app.algorithm.numbers.area_calculator;

import java.util.function.ToDoubleFunction;

/**
 * The AreaCalculator interface defines a method for calculating the area under a curve.
 *
 * @param <T> the type of the function parameter (must extend Number)
 */

public interface IntegralAreaCalculator<T extends Number> {
    /**
     * Calculates the area under the curve defined by the given function using a numerical method.
     *
     * @param a        the lower limit of integration
     * @param b        the upper limit of integration
     * @param quantity the number of intervals for approximation
     * @param function the function for which the area is to be calculated
     * @return the approximate area under the curve
     */
    double calculate(double a, double b, int quantity, ToDoubleFunction<T> function);
}
