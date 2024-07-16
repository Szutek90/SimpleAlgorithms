package com.app.algorithm.numbers;

import com.app.validator.many.impl.IntListAllPositiveListValidator;

import java.util.List;

/**
 * The HornerNumberRepresentation interface provides a method for evaluating a polynomial using Horner's method.
 */

public interface HornerNumberRepresentation {
    /**
     * Evaluates a polynomial using Horner's method and returns its representation in the given base.
     *
     * @param num  the number representing the polynomial
     * @param base the base for the representation
     * @return the string representation of the polynomial in the given base
     * @throws IllegalArgumentException if the base is out of range
     */

    static String evaluatePolynomial(int num, int base) {
        IntListAllPositiveListValidator.validateAll(List.of(num, base));
        if (base > 16) {
            throw new IllegalArgumentException("Base out of range");
        }
        var sb = new StringBuilder();
        while (num != 0) {
            var modulo = num % base;
            if (modulo > 9) {
                sb.insert(0, (char) (modulo + 55));
            } else {
                sb.insert(0, modulo);
            }
            num /= base;
        }
        return sb.toString();
    }
}
