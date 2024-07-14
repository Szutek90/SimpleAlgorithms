package com.app.validator.many;

import java.util.List;
import java.util.function.Predicate;

/**
 * The ListValidator interface defines a method to validate a list of elements using a tester predicate.
 *
 * @param <T> the type of elements in the list
 */

public interface ListValidator<T> {
    /**
     * Validates all elements in the list using the provided tester predicate.
     *
     * @param tester the predicate used to test each element
     * @param values the list of elements to validate
     * @throws NullPointerException     if the tester is null
     * @throws IllegalArgumentException if validation fails for any element
     */

    default void validateAll(Predicate<T> tester, List<T> values) {
        if (tester == null) {
            throw new NullPointerException("tester is null");
        }
        else if (values == null || values.isEmpty()) {
            throw new NullPointerException("values is null or empty");
        }
        for (T value : values) {
            if (!tester.test(value)) {
                throw new IllegalArgumentException("Validation failed");
            }
        }
    }
}
