package com.app.algorithm.searching_and_sorting.searching.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class OptimalFinderTest {
    static OptimalFinder finder;

    @BeforeAll
    static void beforeAll() {
        finder = new OptimalFinder();
    }

    @Test
    @DisplayName("when finding min and max by optimal methode with not even quantity of elements")
    void test1() {
        Assertions.assertThat(finder.find(List.of(98, 101, -5, 0, 24)))
                .containsExactly(-5, 101);
    }

    @Test
    @DisplayName("when finding min and max by optimal methode with even quantity of elements")
    void test2() {
        Assertions.assertThat(finder.find(List.of(98, 101, -5, 0, 24, -26)))
                .containsExactly(-5, 101);
    }
}
