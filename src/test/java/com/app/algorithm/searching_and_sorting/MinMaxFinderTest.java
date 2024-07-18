package com.app.algorithm.searching_and_sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MinMaxFinderTest {
    List<Integer> values;

    @BeforeEach
    void beforeEach() {
        values = new ArrayList<>(List.of(-18, -99, 0, 64, 12));
    }

    @Test
    @DisplayName("when using naive search with not even list")
    void test1() {
        assertThat(MinMaxFinder.naiveSearch(values)).containsExactly(-99, 64);
    }

    @Test
    @DisplayName("when using optimal search with not even list")
    void test2() {
        assertThat(MinMaxFinder.optimalSearch(values)).containsExactly(-99, 64);
    }

    @Test
    @DisplayName("when using optimal search with even list")
    void test3() {
        var values = new ArrayList<>(List.of(-18, -99, 0, 64, 12, 87));
        assertThat(MinMaxFinder.optimalSearch(values)).containsExactly(-99, 87);
    }

    @Test
    @DisplayName("when using by sorting search with not even list")
    void test4() {
        assertThat(MinMaxFinder.bySorting(values)).containsExactly(-99, 64);
    }
}
