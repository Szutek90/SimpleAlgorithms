package com.app.algorithm.numbers;

/**
 * Utility class for converting numbers between different numerical bases.
 */
public class NumberBaseConverter {

    private final int base;

    /**
     * Constructs a NumberBaseConverter object with the specified numerical base.
     *
     * @param base the base to convert numbers to or from (between 2 and 16 inclusive)
     * @throws IllegalArgumentException if the base is out of range (less than 2 or greater than 16)
     */
    public NumberBaseConverter(int base) {
        if (base > 16 || base < 0) {
            throw new IllegalArgumentException("Base out of range");
        }
        this.base = base;
    }

    /**
     * Converts a decimal integer to a string representation in the user-specified base.
     *
     * @param num the decimal integer to convert
     * @return the string representation of the number in the specified base
     */

    public String toUserSpecifiedBase(int num) {
        var sb = new StringBuilder();
        while (num != 0) {
            var tempNum = num % base;
            if (tempNum < 10) {
                sb.insert(0, (char) (tempNum + 48));
            } else {
                sb.insert(0, (char) (tempNum + 55));
            }
            num /= base;
        }
        return sb.toString();
    }

    /**
     * Converts a string representation of a number in the user-specified base to a decimal integer.
     *
     * @param numString the string representation of the number in the specified base
     * @return the decimal integer value of the number
     * @throws IllegalArgumentException if the input string is empty
     */

    public int fromUserSpecifiedBase(String numString) {
        if (numString.isEmpty()) {
            throw new IllegalArgumentException("String cannot be empty");
        }
        var chars = numString.toCharArray();
        var num = 0;
        for (char aChar : chars) {
            if (aChar <= '9') {
                num = num * base + (aChar - '0');
            } else {
                num = num * base + (aChar - 'A' + 10);
            }
        }
        return num;
    }
}
