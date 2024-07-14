package com.app.data;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The DataGenerator interface provides static methods for generating random data.
 */

public interface DataGenerator {

    /**
     * Generates a random integer.
     *
     * @return A random integer.
     */

    static int getRandomInt() {
        return ThreadLocalRandom.current().nextInt();
    }

    /**
     * Generates a random integer within the specified range.
     *
     * @param min The minimum value of the range (inclusive).
     * @param max The maximum value of the range (exclusive).
     * @return A random integer within the specified range.
     * @throws IllegalArgumentException If the maximum value is less than or equal to the minimum value.
     */

    static int getRandomIntWithRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Generates a random double within the specified range and precision.
     *
     * @param min       The minimum value of the range (inclusive).
     * @param max       The maximum value of the range (exclusive).
     * @param precision The number of decimal places in the generated double.
     * @return A random double within the specified range and precision.
     * @throws IllegalArgumentException If the precision is less than or equal to zero, or if the range is invalid.
     */

    static double getRandomDblWithRange(double min, double max, int precision) {
        if (precision <= 0) {
            throw new IllegalArgumentException("Precision should be greater than zero");
        }
        var x = Math.pow(10, precision);
        return getRandomIntWithRange((int) (min * x), (int) (max * x) + 1) / x;
    }
}

