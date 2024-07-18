package com.app.algorithm.searching_and_sorting.searching.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class FinderBySortingTest {

    @Test
    @DisplayName("when finding min and max by sorting")
    void test() {
        var finder = new FinderBySorting();
        Assertions.assertThat(finder.find(List.of(98, 101, -5, 0, 24)))
                .containsExactly(-5, 101);
    }
}
