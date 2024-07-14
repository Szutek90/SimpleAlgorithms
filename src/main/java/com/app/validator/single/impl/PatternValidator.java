package com.app.validator.single.impl;

import com.app.validator.single.Validator;

import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * The PatternValidator class provides methods for validating strings based on a specified regular expression pattern.
 * It implements the Validator interface for generic string validation.
 */

public class PatternValidator implements Validator<String> {
    private final Pattern pattern;

    /**
     * Constructs a PatternValidator with the specified regular expression pattern.
     *
     * @param pattern The regular expression pattern used for validation.
     */
    public PatternValidator(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

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
     * Checks if the given text matches the specified regular expression pattern.
     *
     * @param text The text to be validated.
     * @return True if the text matches the pattern, false otherwise.
     */
    public boolean isMatching(String text) {
        return pattern.matcher(text).matches();
    }
}
