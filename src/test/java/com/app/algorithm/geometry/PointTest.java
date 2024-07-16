package com.app.algorithm.geometry;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {
    private static Point p1;
    private static Point p2;

    @BeforeAll
    static void beforeAll(){
        p1 = new Point(5, 5);
        p2 = new Point(3,8);
    }

    @Test
    @DisplayName("when substracting points to get x")
    void test1(){
        Assertions.assertThat(p1.subtractGivePointX(p2)).isEqualTo(2);
    }

    @Test
    @DisplayName("when substracting points to get x")
    void test2(){
        Assertions.assertThat(p1.subtractGivenPointY(p2)).isEqualTo(-3);
    }

    @Test
    @DisplayName("when substracting from p1.y, p2.x")
    void test3(){
        Assertions.assertThat(p1.subtractXGivenPointFromY(p2)).isEqualTo(2);
    }

    @Test
    @DisplayName("when point is on line")
    void test4(){
        Assertions.assertThat(p1.isPointOnLine(2,-5)).isTrue();
    }

    @Test
    @DisplayName("when getting point with lower x coordinate")
    void test5(){
        Assertions.assertThat(p1.getPointWithLowerXCoordinate(p2)).isEqualTo(p2);
    }


    @Test
    @DisplayName("when getting point with higher x coordinate")
    void test6(){
        Assertions.assertThat(p1.getPointWithHigherXCoordinate(p2)).isEqualTo(p1);
    }

    @Test
    @DisplayName("when point.x is higher or equal than give another point.x")
    void test7(){
        Assertions.assertThat(p1.xIsHigherOrEqualThan(p2)).isTrue();
    }

    @Test
    @DisplayName("when point.x is lower or equal than give another point.x")
    void test8(){
        Assertions.assertThat(p1.xIsLowerOrEqualThan(p2)).isFalse();
    }

    @Test
    @DisplayName("when getting point with higher y coordinate")
    void test9(){
        Assertions.assertThat(p1.getPointWithLowerYCoordinate(p2)).isEqualTo(p1);
    }

    @Test
    @DisplayName("when getting point with higher y coordinate")
    void test10(){
        Assertions.assertThat(p1.getPointWithHigherYCoordinate(p2)).isEqualTo(p2);
    }

    @Test
    @DisplayName("when point.y is higher or equal than give another point.y")
    void test11(){
        Assertions.assertThat(p1.yIsHigherOrEqualThan(p2)).isFalse();
    }

    @Test
    @DisplayName("when point.y is lower or equal than give another point.y")
    void test12(){
        Assertions.assertThat(p1.yIsLowerOrEqualThan(p2)).isTrue();
    }

    @Test
    @DisplayName("when evaluating linear equation")
    void test13(){
        Assertions.assertThat(p2.evaluateLinearEquation(2,0,-1)).isEqualTo(5);
    }
}
