package com.app.algorithm.numbers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ZeroFinderByBisectionTest {
    @Test
    @DisplayName("when finding zero function by bisection")
    void test1() {
        var finder = new ZeroFinderByBisection(0.00001);
        Assertions.assertThat(finder.findZero(x -> 5 * x + 2, -10, 10)).isEqualTo(-5);
    }
}
