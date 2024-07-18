package com.app.algorithm.searching_and_sorting.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * The Sort interface provides methods for sorting a list of values.
 *
 * @param <T> the type of elements in the list (must extend Comparable)
 */

public interface Sort<T extends Comparable<T>> {
    /**
     * Sorts the given list of values in ascending order using the specified comparator.
     *
     * @param values     the list of values to be sorted
     * @param comparator the comparator to determine the order of elements
     * @return the sorted list of values
     */
    List<T> sort(List<T> values, Comparator<T> comparator);

    /**
     * Sorts the given list of values in descending order using the natural order of elements.
     *
     * @param values the list of values to be sorted
     * @return the sorted list of values in descending order
     */
    default List<T> reverse(List<T> values) {
        return sort(values, Comparator.reverseOrder());
    }
}