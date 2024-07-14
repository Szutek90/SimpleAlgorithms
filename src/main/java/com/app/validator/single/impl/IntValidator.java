package com.app.validator.single.impl;

import com.app.validator.single.Validator;

import java.util.function.Predicate;


/**
 * The IntValidator class implements validation for integer values.
 */
public class IntValidator implements Validator<Integer> {

    /**
     * Validates an integer value to ensure it is positive.
     *
     * @param value the integer value to validate
     * @throws IllegalArgumentException if the validation fails
     */
    @Override
    public void validate(Predicate<Integer> predicate, Integer value) {
        Validator.super.validate(predicate, value);
    }

    /**
     * Static method to validate an integer value using an instance of IntValidator.
     *
     * @param val the integer value to validate
     */
    public static void isPositive(int val) {
        new IntValidator().validate(v -> v > 0, val);
    }
}
