package com.app.algorithm.searching_and_sorting.sorting.impl;

import com.app.algorithm.searching_and_sorting.sorting.Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The QuickSort class implements the Sort interface to perform quick sort on a list of values.
 *
 * @param <T> the type of elements in the list (must extend Comparable)
 */

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<T> sort(List<T> values, Comparator<T> comparator) {
        var sortedList = new ArrayList<>(values);
        quickSort(sortedList, comparator, 0, values.size() - 1);
        return sortedList;
    }

    private void quickSort(List<T> values, Comparator<T> comparator, int low, int high) {
        if (low < high) {
            var pivot = partition(values, low, high, comparator);
            quickSort(values, comparator, low, pivot - 1);
            quickSort(values, comparator, pivot + 1, high);
        }
    }

    private int partition(List<T> values, int low, int high, Comparator<T> comparator) {
        var border = low - 1;
        for (int i = low; i < high; i++) {
            if (comparator.compare(values.get(i), values.get(high)) < 0) {
                swap(values, i, border + 1);
                border++;
            }
        }
        swap(values, border + 1, high);
        return border + 1;
    }

    private void swap(List<T> values, int idxA, int idxB) {
        var temp = values.get(idxA);
        values.set(idxA, values.get(idxB));
        values.set(idxB, temp);
    }
}

