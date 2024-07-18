package com.app.algorithm.searching_and_sorting.searching.impl;

import com.app.algorithm.searching_and_sorting.searching.Finder;

import java.util.ArrayList;
import java.util.List;

/**
 * The NaiveFinder class implements the Finder interface to find the minimum and maximum values in a list using a naive approach.
 */
public class NaiveFinder implements Finder {
    @Override
    public <T extends Comparable<T>> List<T> find(List<T> values) {
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
}
