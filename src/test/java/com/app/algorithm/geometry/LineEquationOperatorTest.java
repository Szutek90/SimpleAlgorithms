package com.app.algorithm.geometry;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineEquationOperatorTest {
    private static LineEquationOperator<Integer> operator;

    @BeforeAll
    static void beforeAll(){
        operator = new LineEquationOperator<>(5,8);
    }

    @Test
    @DisplayName("when point is in of line")
    void test1(){
        var point = new Point(1,13);
        Assertions.assertThat(operator.checkIfPointIsInLine(point)).isTrue();
    }

    @Test
    @DisplayName("when point is out of line")
    void test2(){
        var point = new Point(7,6);
        Assertions.assertThat(operator.checkIfPointIsInLine(point)).isFalse();
    }
}
