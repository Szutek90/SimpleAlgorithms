package com.app.algorithm.searching_and_sorting.searching;

import java.util.List;

/**
 * The Finder interface provides a method for finding the minimum and maximum values in a list.
 */
public interface Finder {
    /**
     * Finds the minimum and maximum values in the given list.
     *
     * @param <T>     the type of elements in the list (must extend Comparable)
     * @param values  the list of values
     * @return a list containing the minimum and maximum values in the input list
     */
    <T extends Comparable<T>> List<T> find(List<T> values);
}