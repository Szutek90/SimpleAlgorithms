package com.app.algorithm.searching_and_sorting.searching.impl;

import com.app.algorithm.searching_and_sorting.searching.Finder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The FinderBySorting class implements the Finder interface to find the minimum and maximum values in a list by sorting it.
 */
public class FinderBySorting implements Finder {
    @Override
    public <T extends Comparable<T>> List<T> find(List<T> values) {
        var mutable = new ArrayList<>(values);
        mutable.sort(Comparator.naturalOrder());
        return List.of(mutable.getFirst(), mutable.getLast());
    }
}
