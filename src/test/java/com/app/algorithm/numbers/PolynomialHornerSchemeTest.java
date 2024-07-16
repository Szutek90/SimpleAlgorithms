package com.app.algorithm.numbers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PolynomialHornerSchemeTest {
    static PolynomialHornerScheme<Integer> horner;

    @BeforeAll
    static void beforeAll() {
        horner = new PolynomialHornerScheme<>(new Integer[]{2, 6, 9});
    }

    @Test
    @DisplayName("when using iteratively methode")
    void test1() {
        Assertions.assertThat(horner.iter(6)).isEqualTo(117);
    }

    @Test
    @DisplayName("when using recursive methode")
    void test2() {
        Assertions.assertThat(horner.recursive(new Integer[]{2,6,9},0,0))
                .isEqualTo(2);
    }
}
