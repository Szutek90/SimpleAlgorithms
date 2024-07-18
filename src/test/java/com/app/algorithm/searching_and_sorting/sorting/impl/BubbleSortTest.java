package com.app.algorithm.searching_and_sorting.sorting.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BubbleSortTest {
    static BubbleSort<Integer> bubbleSort;

    @BeforeAll
    static void beforeAll() {
        bubbleSort = new BubbleSort<>();
    }

    @Test
    @DisplayName("when using bubblesort")
    void test1() {
        Assertions.assertThat(bubbleSort.sort(Arrays.asList(98, 101, -5, 0, 24),
                Integer::compare)).containsExactly(-5, 0, 24, 98, 101);
    }

    @Test
    @DisplayName("when using bubblesort in reverse")
    void test2() {
        Assertions.assertThat(bubbleSort.reverse(new ArrayList<>(List.of(-5, 0, 24, 98, 101))))
                .containsExactly(101,98,24,0,-5);
    }
}
