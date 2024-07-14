package com.app.validator.single.impl;

import com.app.validator.single.Validator;

import java.util.function.Predicate;

/**
 * The DoubleValidator class implements validation for double values.
 */
public class DoubleValidator implements Validator<Double> {

    /**
     * Validates a double value based on the provided predicate.
     *
     * @param predicate the predicate to apply for validation
     * @param value     the double value to validate
     * @throws IllegalArgumentException if the validation fails
     */
    @Override
    public void validate(Predicate<Double> predicate, Double value) {
        Validator.super.validate(predicate, value);
    }

    /**
     * Static method to validate if a double value is positive.
     *
     * @param value the double value to validate
     * @throws IllegalArgumentException if the value is not positive
     */
    public static void isPositive(double value) {
        new DoubleValidator().validate(v -> v > 0, value);
    }
}
