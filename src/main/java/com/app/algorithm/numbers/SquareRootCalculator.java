package com.app.algorithm.numbers;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The SquareRootCalculator interface provides a method for calculating the square root of a number with a given precision.
 */

public interface SquareRootCalculator {
    /**
     * Calculates the square root of the given value with the specified precision.
     *
     * @param <T>       the type of the value (must extend Number)
     * @param value     the value for which to calculate the square root
     * @param precision the number of decimal places for the precision
     * @return the square root of the value with the specified precision
     * @throws IllegalArgumentException if the precision is negative
     */
    static <T extends Number> double getSquareRoot(T value, int precision) {
        if (precision < 0) {
            throw new IllegalArgumentException("Wrong precision");
        }
        var val = value.doubleValue();
        var epsilon = 1 / Math.pow(10, precision);
        var x = val / 2;
        while (Math.abs(x - val / x) >= epsilon) {
            x = (x + val / x) / 2;
        }
        return BigDecimal.valueOf(x).setScale(precision, RoundingMode.HALF_DOWN)
                .doubleValue();
    }
}
