package com.app.algorithm.searching_and_sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The MinMaxFinder interface provides methods for finding the minimum and maximum elements in a list of comparable objects.
 */
public interface MinMaxFinder {
    /**
     * Finds the minimum and maximum elements in the list using a naive approach.
     *
     * @param values the list of values
     * @param <T>    the type of elements in the list, must implement Comparable interface
     * @return a list containing the minimum and maximum elements
     */
    static <T extends Comparable<T>> List<T> naiveSearch(List<T> values) {
        var min = values.getFirst();
        var max = values.getFirst();
        for (int i = 1; i < values.size(); i++) {
            var val = values.get(i);
            if (val.compareTo(min) < 0) {
                min = val;
            } else if (val.compareTo(max) > 0) {
                max = val;
            }
        }
        return new ArrayList<>(List.of(min, max));
    }

    /**
     * Finds the minimum and maximum elements in the list using an optimal approach.
     * This method is more efficient than the naiveSearch method, especially for larger lists.
     *
     * @param values the list of values
     * @param <T>    the type of elements in the list, must implement Comparable interface
     * @return a list containing the minimum and maximum elements
     */
    static <T extends Comparable<T>> List<T> optimalSearch(List<T> values) {
        T min;
        T max;
        int idx;

        if (values.size() % 2 != 0) {
            min = values.getFirst();
            max = values.getFirst();
            idx = 1;
        } else {
            var first = values.getFirst();
            var second = values.get(1);
            min = first.compareTo(second) <= 0 ? first : second;
            max = first.compareTo(second) <= 0 ? second : first;
            idx = 2;
        }

        for (int i = idx; i < values.size() - 1; i += 2) {
            var a = values.get(i);
            var b = values.get(i + 1);
            var smaller = a.compareTo(b) <= 0 ? a : b;
            var larger = a.compareTo(b) <= 0 ? b : a;
            min = smaller.compareTo(min) < 0 ? smaller : min;
            max = larger.compareTo(max) > 0 ? larger : max;
        }

        if (values.size() % 2 != 0) {
            var lastElement = values.getLast();
            min = lastElement.compareTo(min) < 0 ? lastElement : min;
            max = lastElement.compareTo(max) > 0 ? lastElement : max;
        }

        return new ArrayList<>(List.of(min, max));
    }

    /**
     * Finds the minimum and maximum elements in the list by sorting the list.
     * This method sorts the list first and then returns the first and last elements.
     *
     * @param values the list of values
     * @param <T>    the type of elements in the list, must implement Comparable interface
     * @return a list containing the minimum and maximum elements
     */
    static <T extends Comparable<T>> List<T> bySorting(List<T> values) {
        var mutable = new ArrayList<>(values);
        mutable.sort(Comparator.naturalOrder());
        return List.of(mutable.getFirst(), mutable.getLast());
    }

}
