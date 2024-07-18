package com.app.algorithm.searching_and_sorting.sorting.impl;

import com.app.algorithm.searching_and_sorting.sorting.Sort;

import java.util.Comparator;
import java.util.List;

/**
 * The BubbleSort class implements the Sort interface to perform bubble sort on a list of values.
 *
 * @param <T> the type of elements in the list (must extend Comparable)
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public List<T> sort(List<T> values, Comparator<T> comparator) {
        for (int i = 0; i < values.size() - 1; i++) {
            for (int j = 0; j < values.size() - 1 - i; j++) {
                if (comparator.compare(values.get(j), values.get(j + 1)) > 0) {
                    var temp = values.get(j);
                    values.set(j, values.get(j + 1));
                    values.set(j + 1, temp);
                }
            }
        }
        return values;
    }
}
