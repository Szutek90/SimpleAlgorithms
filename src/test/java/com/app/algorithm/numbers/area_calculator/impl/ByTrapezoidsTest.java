package com.app.algorithm.numbers.area_calculator.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ByTrapezoidsTest {
    private static ByTrapezoids calculator;

    @BeforeAll
    public static void beforeAll(){
        calculator = new ByTrapezoids();
    }

    @Test
    @DisplayName("when function is constant")
    void test1(){
        Assertions.assertThat(calculator.calculate(0, 10, 1000, x -> 5.0))
                .isEqualTo(50);
    }

    @Test
    @DisplayName("when function is quadratic")
    void test2(){
        Assertions.assertThat(calculator.calculate(0, 5, 1000, x -> x * x))
                .isEqualTo(41.67);
    }
}
