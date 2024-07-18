package com.app.algorithm.searching_and_sorting.sorting.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QuickSortTest {
    @Nested
    class SortTest {
        @Test
        @DisplayName("when using bubblesort")
        void test() {
            var sorter = new QuickSort<Integer>();
            Assertions.assertThat(sorter.sort(Arrays.asList(10, -50, 30, -20, 18, 36),
                    Integer::compare)).containsExactly(-50, -20, 10, 18, 30, 36);
        }
    }

    @Nested
    class PrivateTests {
        @SuppressWarnings("unchecked")
        private int invokePrivateMethodePartition(List<Integer> values, int low, int high,
                                                  Comparator<Integer> comparator) throws Exception {
            var instance = new QuickSort<Integer>();
            var method = QuickSort.class.getDeclaredMethod("partition", List.class,
                    int.class, int.class, Comparator.class);
            method.setAccessible(true);
            return (int) method.invoke(instance, values, low, high, comparator);
        }

        @Test
        @DisplayName("when using private methode")
        void privateMethode() throws Exception {
            Comparator<Integer> comparator = Integer::compare;
            var values = new ArrayList<>(List.of(10, -50, 30,40,18));

            Assertions.assertThat(invokePrivateMethodePartition(values,2,4, comparator))
                    .isEqualTo(2);
        }
    }
}


