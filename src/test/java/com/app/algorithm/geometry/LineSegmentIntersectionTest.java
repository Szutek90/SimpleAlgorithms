package com.app.algorithm.geometry;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineSegmentIntersectionTest {

    @Test
    @DisplayName("when intersect")
    void test1(){
        var intersect  = new LineSegmentIntersection(new Point(1, 1), new Point(4, 4),
                new Point(1, 4), new Point(4, 1));
        Assertions.assertThat(intersect.areIntersect()).isTrue();
    }

    @Test
    @DisplayName("when not intersect")
    void test2(){
        var noIntersect = new LineSegmentIntersection(new Point(1, 1), new Point(2, 2),
                new Point(3, 3), new Point(4, 4));
        Assertions.assertThat(noIntersect.areIntersect()).isFalse();
    }
}
