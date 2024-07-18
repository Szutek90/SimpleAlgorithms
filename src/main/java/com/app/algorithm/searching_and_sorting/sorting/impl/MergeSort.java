package com.app.algorithm.searching_and_sorting.sorting.impl;

import com.app.algorithm.searching_and_sorting.sorting.Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The MergeSort class implements the Sort interface to perform merge sort on a list of values.
 *
 * @param <T> the type of elements in the list (must extend Comparable)
 */

public class MergeSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public List<T> sort(List<T> values, Comparator<T> comparator) {
        if (values.size() <= 1) {
            return values;
        }
        var half = values.size() / 2;
        var left = sort(values.subList(0, half), comparator);
        var right = sort(values.subList(half, values.size()), comparator);
        return merge(left, right, comparator);
    }

    private List<T> merge(List<T> left, List<T> right, Comparator<T> comparator) {
        var sorted = new ArrayList<T>();
        var idx1 = 0;
        var idx2 = 0;
        while (idx1 < left.size() && idx2 < right.size()) {
            var leftElement = left.get(idx1);
            var rightElement = right.get(idx2);
            if (comparator.compare(leftElement, rightElement) >= 0) {
                sorted.add(rightElement);
                idx2++;
            } else {
                sorted.add(leftElement);
                idx1++;
            }
        }
        while (idx1 < left.size()) {
            sorted.add(left.get(idx1));
            idx1++;
        }
        while (idx2 < right.size()) {
            sorted.add(right.get(idx2));
            idx2++;
        }
        return sorted;
    }
}
