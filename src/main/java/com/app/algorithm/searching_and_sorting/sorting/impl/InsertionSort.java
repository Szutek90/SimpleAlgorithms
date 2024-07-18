package com.app.algorithm.searching_and_sorting.sorting.impl;

import com.app.algorithm.searching_and_sorting.sorting.Sort;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * The InsertionSort class implements the Sort interface to perform insertion sort on a list of values.
 *
 * @param <T> the type of elements in the list (must extend Comparable)
 */

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public List<T> sort(List<T> values, Comparator<T> comparator) {
        var mutable = new LinkedList<>(values);
        for (int i = 1; i < mutable.size(); i++) {
            var j = i - 1;
            var current = mutable.get(i);
            while (j >= 0 && comparator.compare(current, mutable.get(j)) < 0) {
                mutable.set(j + 1, mutable.get(j));
                j--;
            }
            mutable.set(j + 1, current);
        }
        return mutable;
    }
}

