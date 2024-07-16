package com.app.algorithm.numbers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GreedyMethodTest {

    @Test
    @DisplayName("when using avilable denominations")
    void test1() {
        var greedy = new GreedyMethod(new int[]{5, 10, 20, 50, 100, 200, 500});
        Assertions.assertThat(greedy.givingChange(568)).containsExactly(500, 50, 10, 5);
    }
}
