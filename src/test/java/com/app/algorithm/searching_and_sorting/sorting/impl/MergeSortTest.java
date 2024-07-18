package com.app.algorithm.searching_and_sorting.sorting.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MergeSortTest {

    @Nested
    class SortTest {
        @Test
        @DisplayName("when using bubblesort")
        void test() {
            var sorter = new MergeSort<Integer>();
            Assertions.assertThat(sorter.sort(Arrays.asList(10, -50, 30, -20, 18, 36),
                    Integer::compare)).containsExactly(-50, -20, 10, 18, 30, 36);
        }
    }

    @Nested
    class PrivateTests {
        @SuppressWarnings("unchecked")
        private List<Integer> invokePrivateMethode(List<Integer> left, List<Integer> right,
                                                   Comparator<Integer> comparator) throws Exception {
            var instance = new MergeSort<Integer>();
            var method = MergeSort.class.getDeclaredMethod("merge", List.class, List.class,
                    Comparator.class);
            method.setAccessible(true);
            return (List<Integer>) method.invoke(instance, left, right, comparator);
        }

        @Test
        @DisplayName("when using private methode")
        void privateMethode() throws Exception {
            Comparator<Integer> comparator = Integer::compare;
            var left = new ArrayList<>(List.of(10, -50, 30));
            var right = new ArrayList<>(List.of(-20, 18, 36));

            Assertions.assertThat(invokePrivateMethode(left, right, comparator))
                    .containsExactly(-20, 10, -50, 18, 30, 36);
        }
    }
}
