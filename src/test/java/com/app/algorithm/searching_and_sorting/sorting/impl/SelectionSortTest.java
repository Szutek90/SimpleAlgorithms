package com.app.algorithm.searching_and_sorting.sorting.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SelectionSortTest {

    @Test
    @DisplayName("when using selection sort")
    void test() {
        var sorter = new SelectionSort<Integer>();
        Assertions.assertThat(sorter.sort(Arrays.asList(98, 101, -5, 0, 24),
                Integer::compare)).containsExactly(-5, 0, 24, 98, 101);
    }
}
