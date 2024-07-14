package com.app.validator.many.impl;

import com.app.validator.many.ListValidator;

import java.util.List;

/**
 * The IntListAllPositiveListValidator class validates whether all elements in a list of integers are positive.
 */

public class IntListAllPositiveListValidator implements ListValidator<Integer> {
    /**
     * Validates whether all elements in the list are positive integers.
     *
     * @param values the list of integers to validate
     */

    public void validate(List<Integer> values) {
        ListValidator.super.validateAll(v -> v > 0, values);
    }

    /**
     * Validates whether all elements in the given list are positive integers.
     *
     * @param values the list of integers to validate
     */

    public static void validateAll(List<Integer> values) {
        new IntListAllPositiveListValidator().validate(values);
    }
}
