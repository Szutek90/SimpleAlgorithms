package com.app.validator.single;

import java.util.function.Predicate;

/**
 * A functional interface for validating values.
 *
 * @param <T> the type of value to be validated
 */

public interface Validator<T> {
    /**
     * Validates a value against a given predicate.
     *
     * @param predicate the predicate to test the value against
     * @param value     the value to be validated
     * @throws IllegalArgumentException if the predicate is null or the value does not satisfy the predicate
     */

    default void validate(Predicate<T> predicate, T value) {
        if (predicate == null) {
            throw new NullPointerException("Predicate is null");
        }
        if (!predicate.test(value)) {
            throw new IllegalArgumentException("Value contains invalid value");
        }
    }
}
