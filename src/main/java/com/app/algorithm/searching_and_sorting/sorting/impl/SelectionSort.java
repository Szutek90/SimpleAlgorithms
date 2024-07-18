package com.app.algorithm.searching_and_sorting.sorting.impl;

import com.app.algorithm.searching_and_sorting.sorting.Sort;

import java.util.Comparator;
import java.util.List;

/**
 * The SelectionSort class implements the Sort interface to perform selection sort on a list of values.
 *
 * @param <T> the type of elements in the list (must extend Comparable)
 */

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public List<T> sort(List<T> values, Comparator<T> comparator) {
        for (int i = 0; i < values.size() - 1; i++) {
            var idx = i;
            for (int j = i + 1; j < values.size(); j++) {
                if (comparator.compare(values.get(j),values.get(idx)) < 0) {
                    idx = j;
                }
            }
            if (idx != i) {
                var temp = values.get(i);
                values.set(i, values.get(idx));
                values.set(idx, temp);
            }
        }
        return values;
    }
}
