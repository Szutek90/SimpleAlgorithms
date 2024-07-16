package com.app.algorithm.numbers;

/**
 * The PolynomialHornerScheme class provides methods for evaluating a polynomial using Horner's scheme.
 * This scheme allows efficient polynomial evaluation by reducing the number of multiplications needed.
 *
 * @param <T> the type of the coefficients (must extend Number)
 */

public class PolynomialHornerScheme <T extends Number>{

    /** The coefficients of the polynomial. */
    private final T[] coefficients;

    /**
     * Constructs a PolynomialHornerScheme object with the specified coefficients.
     *
     * @param coefficients the coefficients of the polynomial
     */
    public PolynomialHornerScheme(T[] coefficients) {
        this.coefficients = coefficients;
    }

    /**
     * Evaluates the polynomial using Horner's scheme iteratively.
     *
     * @param x the value at which to evaluate the polynomial
     * @return the result of evaluating the polynomial
     */

    public double iter(T x) {
        var result = coefficients[0].doubleValue();
        for (int i = 1; i < coefficients.length; i++) {
            result = result *  x.doubleValue() + coefficients[i].doubleValue();
        }
        return result;
    }

    /**
     * Evaluates the polynomial using Horner's scheme recursively.
     *
     * @param coefficients the coefficients of the polynomial
     * @param idx          the current index of the coefficient being processed
     * @param result       the intermediate result
     * @return the result of evaluating the polynomial
     */

    public double recursive(T[] coefficients, int idx, double result) {
        if (idx == coefficients.length - 1) {
            return coefficients[idx].doubleValue();
        }
        return result * recursive(coefficients, idx + 1, result) + coefficients[idx].doubleValue();
    }
}
