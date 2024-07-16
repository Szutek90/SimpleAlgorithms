package com.app.algorithm.geometry;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointLinePositionTest {

    @Test
    @DisplayName("when point is on line")
    void test1(){
        var line = new PointLinePosition<>(2.0, -3.0, 6.0);
        var point = new Point(0.0, 2.0);
        Assertions.assertThat(line.getPosition(point)).isZero();
    }

    @Test
    @DisplayName("when point is above line")
    void test2(){
        var line = new PointLinePosition<>(2.0, -1.0, 1.0);
        var point = new Point(1.0, 1.0);
        Assertions.assertThat(line.getPosition(point)).isEqualTo(1);
    }

    @Test
    @DisplayName("when point is below line")
    void test3(){
        var line = new PointLinePosition<>(1.0, -1.0, 0.0);
        var point = new Point(1.0, 2.0);
        Assertions.assertThat(line.getPosition(point)).isEqualTo(-1);
    }
}
