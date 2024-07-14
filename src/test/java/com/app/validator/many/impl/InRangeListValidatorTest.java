package com.app.validator.many.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Stream;

class InRangeListValidatorTest {
    private static InRangeListValidator<Integer> validator;

    @BeforeAll
    static void beforeAll() {
        validator = new InRangeListValidator<>(5, 10);
    }

    @Test
    @DisplayName("When all values in range")
    void test1() {
        Assertions.assertThatCode(() -> validator.validate(List.of(6, 7, 8, 9)))
                .doesNotThrowAnyException();
    }

    static Stream<Arguments> withWrongRange() {
        return Stream.of(
                Arguments.of(List.of(4, 7, 8, 12)),
                Arguments.of(List.of(-10, -5, -1)),
                Arguments.of(List.of(20, 30, 40))
        );
    }

    @ParameterizedTest
    @DisplayName("When values are not correct")
    @MethodSource("withWrongRange")
    void test2(List<Integer> values) {
        Assertions.assertThatThrownBy(() -> validator.validate(values))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("When list is empty or null")
    @NullAndEmptySource
    void test5(List<Integer> values) {
        Assertions.assertThatThrownBy(() -> validator.validate(values))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("When all values in range static methode")
    void test6() {
        var values = List.of(6, 7, 8, 9);
        Assertions.assertThatCode(() -> InRangeListValidator.validateRange(values, 5, 10))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("When some values out of range in static methode ")
    void test7() {
        var values = List.of(10, 20, 30, 40);
        Assertions.assertThatThrownBy(() -> InRangeListValidator.validateRange(values, 15, 35))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
