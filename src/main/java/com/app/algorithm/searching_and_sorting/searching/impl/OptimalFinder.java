package com.app.algorithm.searching_and_sorting.searching.impl;

import com.app.algorithm.searching_and_sorting.searching.Finder;

import java.util.ArrayList;
import java.util.List;

/**
 * The OptimalFinder class implements the Finder interface to find the minimum and maximum values in a list using an optimal approach.
 */
public class OptimalFinder implements Finder {
    @Override
    public <T extends Comparable<T>> List<T> find(List<T> values) {
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
            var a = values.get(idx);
            var b = values.get(idx + 1);
            var smaller = a.compareTo(b) <= 0 ? a : b;
            var higher = a.compareTo(b) <= 0 ? b : a;
            min = smaller.compareTo(min) <= 0 ? smaller : min;
            max = higher.compareTo(max) <= 0 ? max : higher;
        }
        return new ArrayList<>(List.of(min, max));
    }
}
