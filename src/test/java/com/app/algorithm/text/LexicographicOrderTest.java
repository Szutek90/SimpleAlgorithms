package com.app.algorithm.text;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LexicographicOrderTest {
    @Test
    void test() {
        Assertions.assertThat(LexicographicOrder.order(new ArrayList<>(
                        List.of("mama", "simba", "lili", "abba"))))
                .containsExactly("abba", "lili", "mama", "simba");
    }
}
