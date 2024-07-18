package com.app.algorithm.searching_and_sorting.searching.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class NaiveFinderTest {

    @Test
    @DisplayName("when finding min and max by naive")
    void test() {
        var finder = new NaiveFinder();
        Assertions.assertThat(finder.find(List.of(98, 101, -5, 0, 24)))
                .containsExactly(-5, 101);
    }
}
