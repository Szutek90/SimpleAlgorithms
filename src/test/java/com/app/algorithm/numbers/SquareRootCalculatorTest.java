package com.app.algorithm.numbers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SquareRootCalculatorTest {
    @Test
    @DisplayName("when using square root")
    void test1(){
        Assertions.assertThat(SquareRootCalculator.getSquareRoot(8,4)).isEqualTo(2.8284);
    }

    @Test
    @DisplayName("when precision is negative")
    void test2(){
        Assertions.assertThatThrownBy(()->SquareRootCalculator.getSquareRoot(8,-4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Wrong precision");
    }
}
