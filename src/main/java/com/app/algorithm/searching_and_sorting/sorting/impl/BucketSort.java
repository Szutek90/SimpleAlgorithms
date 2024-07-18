package com.app.algorithm.searching_and_sorting.sorting.impl;

import com.app.algorithm.searching_and_sorting.sorting.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The BucketSort class implements the Sort interface to perform bucket sort on a list of values.
 *
 * @param <T> the type of elements in the list (must extend Number and Comparable)
 */
public class BucketSort<T extends Number & Comparable<T>> implements Sort<T> {
    @Override
    public List<T> sort(List<T> values, Comparator<T> comparator) {
        var max = Collections.max(values);
        var min = Collections.min(values);
        var bucketsQuantity = (int) Math.ceil(max.doubleValue() / values.size());
        var buckets = new ArrayList<List<T>>();
        for (int i = 0; i <= bucketsQuantity; i++) {
            buckets.add(new ArrayList<>());
        }
        for (var value : values) {
            buckets.get((int) (((value.doubleValue() - min.doubleValue()) /
                    (max.doubleValue() - min.doubleValue())) * (bucketsQuantity - 1))).add(value);
        }
        return getSortedList(buckets, comparator);
    }

    private List<T> getSortedList(List<List<T>> buckets, Comparator<T> comparator) {
        var sorted = new ArrayList<T>();
        for (var bucket : buckets) {
            bucket.sort(comparator);
            sorted.addAll(bucket);
        }
        return sorted;
    }
}
