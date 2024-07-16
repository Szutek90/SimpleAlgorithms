package com.app.algorithm.geometry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TriangleRuleCheckerTest {

    @Test
    @DisplayName("when can be triangle")
    void test1(){
        var triangle = new TriangleRuleChecker<>(3,5,6);
        assertThat(triangle.canBeTriangle()).isTrue();
    }

    @Test
    @DisplayName("when is equilateral")
    void test2(){
        var triangle = new TriangleRuleChecker<>(6,6,6);
        assertThat(triangle.isEquilateral()).isTrue();
    }

    @Test
    @DisplayName("when is isosceles")
    void test3(){
        var triangle = new TriangleRuleChecker<>(6,6,10);
        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Test
    @DisplayName("when is scalene")
    void test5(){
        var triangle = new TriangleRuleChecker<>(3,4,5);
        assertThat(triangle.isScalene()).isTrue();
    }

    @Test
    @DisplayName("when is rectangular")
    void test6(){
        var triangle = new TriangleRuleChecker<>(3,4,5);
        assertThat(triangle.isRectangular()).isTrue();
    }

    @Test
    @DisplayName("when perimeter is true")
    void test7(){
        var triangle = new TriangleRuleChecker<>(5,10,8);
        assertThat(triangle.getPerimeter()).isEqualTo(23);
    }

    @Test
    @DisplayName("when area is true")
    void test8(){
        var triangle = new TriangleRuleChecker<>(5,10,8);
        assertThat(triangle.getArea()).isEqualTo(19.81);
    }
}
