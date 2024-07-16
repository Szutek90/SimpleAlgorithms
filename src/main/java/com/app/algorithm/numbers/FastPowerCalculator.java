package com.app.algorithm.numbers;

/**
 * The FastPowerCalculator interface provides a method for calculating the power of a number using a fast algorithm.
 */

public interface FastPowerCalculator {

    /**
     * Calculates the power of a base raised to an exponent.
     *
     * @param base     the base number
     * @param exponent the exponent
     * @return the result of base raised to the exponent
     */

    static double calculate(int base, int exponent) {
        if (exponent < 1) {
            return (double) 1 / power(base, Math.abs(exponent));
        } else {
            return power(base, exponent);
        }

    }

    private static int power(int base, int exponent) {
        var binary = HornerNumberRepresentation.evaluatePolynomial(exponent, 2);
        var result = 1;
        for (int i = 0; i < binary.length(); i++) {
            result *= result;
            if (binary.charAt(i) == '1') {
                result *= base;
            }
        }
        return result;
    }
}
