package com.app.algorithm.text;

import java.util.ArrayList;
import java.util.List;

/**
 * The LexicographicOrder class provides a static method to order a list of strings lexicographically.
 */

public interface LexicographicOrder {
    /**
     * Orders the given list of strings lexicographically.
     *
     * @param texts the list of strings to be ordered
     * @return the ordered list of strings
     */

    static List<String> order(List<String> texts) {
        var newArr = new ArrayList<>(texts);
        for (int i = 1; i < newArr.size(); i++) {
            int j = i - 1;
            var current = newArr.get(i);
            while (j >= 0 && newArr.get(j).compareTo(current) > 0) {
                newArr.set(j + 1, newArr.get(j));
                j--;
            }
            newArr.set(j + 1, current);
        }
        return newArr;
    }
}
