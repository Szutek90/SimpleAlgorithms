package com.app.validator.single.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;


class StringValidatorTest {
    private static final StringValidator validator = new StringValidator();

    @Test
    @DisplayName("When null is given as predicate")
    void test1(){
        Assertions.assertThatCode(() -> validator.validate(null, "test string"))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("When null is given in static methode")
    void test2(){
        Assertions.assertThatCode(() -> StringValidator.isEmpty(null))
                .isInstanceOf(NullPointerException.class);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("When empty String is given static methode")
    void test3(String s) {
        Assertions.assertThatCode(() -> StringValidator.isEmpty(s))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("When String is not null in static methode")
    void test4() {
        Assertions.assertThatCode(() -> StringValidator.isEmpty("TEST"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("When String pass validation")
    void test5() {
        Assertions.assertThatCode(() -> validator.validate(str -> str.length() == 3,
                "xyz")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("When String does not pass validation")
    void test6() {
        Assertions.assertThatCode(() -> validator.validate(str -> str.length() == 8,
                "xyz")).isInstanceOf(IllegalArgumentException.class);
    }
}
