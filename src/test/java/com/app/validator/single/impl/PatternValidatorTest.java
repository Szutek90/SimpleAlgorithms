package com.app.validator.single.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.function.Predicate;

class PatternValidatorTest {
    private static final PatternValidator validator = new PatternValidator("PATTERN test");

    @ParameterizedTest
    @NullSource
    @DisplayName("When null predicate given")
    void test1(Predicate<String> predicate) {
        Assertions.assertThatThrownBy(() -> validator.validate(predicate, "test"))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("When given string matches pattern")
    void test2() {
        Assertions.assertThat(validator.isMatching("PATTERN test")).isTrue();
    }

    @Test
    @DisplayName("When given string does not matches pattern")
    void test3() {
        Assertions.assertThat(validator.isMatching("WONT FIT")).isFalse();
    }

    @Test
    @DisplayName("When predicate is incorrect")
    void test4() {
        Assertions.assertThatCode(() -> validator
                .validate(str -> str.endsWith("B"), "ABC")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("When predicate is correct")
    void test5() {
        Assertions.assertThatCode(()-> validator.validate(str->str.endsWith("B"),
                "ABB")).doesNotThrowAnyException();
    }
}
