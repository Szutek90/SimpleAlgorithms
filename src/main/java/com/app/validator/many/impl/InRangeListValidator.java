package com.app.validator.many.impl;

import com.app.validator.many.ListValidator;

import java.util.List;

/**
 * The InRangeListListValidator class validates whether all elements in a list fall within a specified range.
 *
 * @param <T> the type of elements in the list
 */

public class InRangeListValidator<T extends Comparable<T>> implements ListValidator<T> {
    private final T left;
    private final T right;

    /**
     * Constructs a new InRangeListListValidator with the specified range.
     *
     * @param left  the left bound of the range
     * @param right the right bound of the range
     */
    public InRangeListValidator(T left, T right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Validates whether all elements in the list fall within the specified range.
     *
     * @param values the list of values to validate
     */

    public void validate(List<T> values) {
        ListValidator.super.validateAll(v -> left.compareTo(v) <= 0 && right.compareTo(v) >= 0, values);
    }

    /**
     * Validates whether all elements in the given list fall within the specified range.
     *
     * @param <T>    the type of elements in the list
     * @param values the list of values to validate
     * @param min    the minimum value of the range
     * @param max    the maximum value of the range
     */

    public static <T extends Comparable<T>> void validateRange(List<T> values, T min, T max) {
        new InRangeListValidator<>(min, max).validate(values);
    }

}
