package com.app.validator.single.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.function.Predicate;

class IntValidatorTest {
    private static final IntValidator validator = new IntValidator();

    @Test
    @DisplayName("When value is positive static methode")
    void test() {
        Assertions.assertThatCode(() -> IntValidator.isPositive(50))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("When value is negative static methode")
    void test2() {
        Assertions.assertThatThrownBy(() -> IntValidator.isPositive(-20))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("When null predicate given")
    void test3(Predicate<Integer> predicate) {
        Assertions.assertThatThrownBy(() -> validator.validate(predicate, 10))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("When value pass given predicate")
    void test4() {
        Assertions.assertThatCode(() -> validator.validate(aDouble -> aDouble == 9,9))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("When value does not pass given predicate")
    void test5() {
        Assertions.assertThatThrownBy(() -> validator.validate(aDouble -> aDouble == 9,10))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
