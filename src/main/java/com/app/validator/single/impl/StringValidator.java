package com.app.validator.single.impl;

import com.app.validator.single.Validator;

import java.util.function.Predicate;

/**
 * The StringValidator class provides methods for validating strings based on predicates.
 * It implements the Validator interface for generic string validation.
 */

public class StringValidator implements Validator<String> {
    /**
     * Validates the given value based on the provided predicate.
     *
     * @param predicate The predicate used for validation.
     * @param value     The value to be validated.
     * @throws IllegalArgumentException If the validation fails.
     */

    @Override
    public void validate(Predicate<String> predicate, String value) {
        Validator.super.validate(predicate, value);
    }

    /**
     * Validates if the given string is empty.
     *
     * @param value The string to be validated.
     * @throws IllegalArgumentException If the string is empty.
     */

    public static void isEmpty(String value) {
        new StringValidator().validate(s -> !s.isEmpty(), value);
    }
}
