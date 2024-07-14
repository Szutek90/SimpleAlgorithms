package com.app.validator.single.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.function.Predicate;

class DoubleValidatorTest {

    private static DoubleValidator validator;

    @BeforeAll
    static void beforeAll() {
        validator = new DoubleValidator();
    }

    @Test
    @DisplayName("When value is positive static methode")
    void test() {
        Assertions.assertThatCode(() -> DoubleValidator.isPositive(50.1))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("When value is negative static methode")
    void test2() {
        Assertions.assertThatThrownBy(() -> DoubleValidator.isPositive(-20.3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("When null predicate given")
    void test3(Predicate<Double> predicate) {
        Assertions.assertThatThrownBy(() -> validator.validate(predicate, 10.2))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("When value pass given predicate")
    void test4() {
        Assertions.assertThatCode(() -> validator.validate(aDouble -> aDouble == 9.8,9.8))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("When value does not pass given predicate")
    void test5() {
        Assertions.assertThatThrownBy(() -> validator.validate(aDouble -> aDouble == 9.8,10.8))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
