package com.app.algorithm.numbers;

import com.app.validator.single.impl.IntValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyMethod {
    private final int[] denominations;

    /**
     * Constructs a new GreedyMethod object with the specified set of denominations.
     *
     * @param denominations the denominations available for giving change
     */
    public GreedyMethod(int[] denominations) {
        this.denominations = Arrays.stream(denominations)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
    }

    /**
     * Calculates the change to be given for a specified value using the greedy algorithm.
     * The method returns an array containing the denominations used to give the change.
     *
     * @param value the value for which change is to be given
     * @return an array representing the denominations used to give the change
     * @throws IllegalArgumentException if the specified value is not a positive integer
     */

    public int[] givingChange(int value) {
        IntValidator.isPositive(value);
        var change = new ArrayList<Integer>();
        var i = 0;
        while (value != 0) {
            while (value >= denominations[i]) {
                change.add(denominations[i]);
                value -= denominations[i];
            }
            i++;
            if(i >= denominations.length){
                break;
            }
        }
        return change.stream()
                .mapToInt(value1 -> value1).toArray();
    }
}
