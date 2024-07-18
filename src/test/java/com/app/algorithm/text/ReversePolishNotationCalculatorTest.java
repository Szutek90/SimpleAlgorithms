package com.app.algorithm.text;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReversePolishNotationCalculatorTest {

    @Test
    @DisplayName("when using polish notation calculator")
    void test1() {
        Assertions.assertThat(ReversePolishNotationCalculator
                        .evaluateExpression("24+46-*"))
                .isEqualTo(-12);
    }
}

