package com.app.algorithm.numbers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class FastPowerCalculatorTest {

    @Test
    @DisplayName("when when exponent is positive")
    void test1() {
        Assertions.assertThat(FastPowerCalculator.calculate(2, 3)).isEqualTo(8);
    }
    @Test
    @DisplayName("when when exponent is less than 1")
    void test2() {
        Assertions.assertThat(FastPowerCalculator.calculate(2, -3)).isEqualTo(0.125);
    }

}
