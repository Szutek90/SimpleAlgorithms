package com.app.validator.many.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

class IntListAllPositiveListValidatorTest {
    private static IntListAllPositiveListValidator validator;

    @BeforeAll
    static void beforeAll() {
        validator = new IntListAllPositiveListValidator();
    }

    @Test
    @DisplayName("When all values are positive")
    void test1() {
        var values = List.of(1, 5, 10, 20);
        Assertions.assertThatCode(() -> validator.validate(values))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("When some values are not positive")
    void test2() {
        var values = List.of(1, 5, -10, -20);
        Assertions.assertThatCode(() -> validator.validate(values))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("When all values are positive static methode")
    void test3() {
        var values = List.of(1, 5, 10, 20);
        Assertions.assertThatCode(() -> IntListAllPositiveListValidator.validateAll(values))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("When some values are not positive static methode")
    void test4() {
        var values = List.of(1, 5, -10, -20);
        Assertions.assertThatCode(() -> IntListAllPositiveListValidator.validateAll(values))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void test5(List<Integer> values) {
        Assertions.assertThatThrownBy(() -> validator.validate(values))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("when tester is null")
    void test6() {
        var values = List.of(1, 5, -10, -20);
        Assertions.assertThatThrownBy(() ->
                validator.validateAll(null, values))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("tester is null");
    }
}
