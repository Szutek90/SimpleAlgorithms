package com.app.algorithm.geometry;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CirclePointCheckerTest {
    private static CirclePointChecker<Integer> checker;

    @BeforeAll
    public static void beforeAll() {
        checker = new CirclePointChecker<Integer>(new Point(2, 4), 12);
    }

    @Test
    @DisplayName("when point is inside circle")
    void test1(){
        var point = new Point(4,8);
        Assertions.assertThat(checker.isInside(point)).isTrue();
    }

    @Test
    @DisplayName("when point is outside of circle")
    void test2(){
        var point = new Point(20,30);
        Assertions.assertThat(checker.isInside(point)).isFalse();
    }
}
