package com.app.algorithm.numbers;

import com.app.algorithm.numbers.gcd.Gcd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Following methodes works on a positive integers.
 */
public interface SimpleAlgorithms {

    /**
     * Checks if a given integer is a prime number.
     *
     * @param value the integer to check
     * @return true if the given integer is prime, false otherwise
     */
    static boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        } else if (value == 2 || value == 3) {
            return true;
        } else if (value % 2 == 0 || value % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= value; i += 6) {
            if (value % i == 0 || value % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Counts the number of divisors of a given integer.
     *
     * @param num                the integer for which to count divisors
     * @param zeroAndNumIncluded if true, includes 0 and num in the count, otherwise excludes them
     * @return the number of divisors of the given integer
     */

    static int countDivisors(int num, boolean zeroAndNumIncluded) {
        var multiplier = 1;
        if (num == 0) {
            return Integer.MAX_VALUE;
        } else if (num < 0) {
            multiplier = 2;
            num = Math.abs(num);
        }
        var counter = zeroAndNumIncluded ? 2 : 0;
        int i;
        for (i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                counter += 2;
            }
        }
        if (i * i == num) {
            counter++;
        }
        return counter * multiplier;
    }

    /**
     * Checks if a given integer is a perfect number.
     *
     * @param value the integer to check
     * @return true if the given integer is a perfect number, false otherwise
     */
    static boolean isPerfect(int value) {
        var divisors = getDivisors(value);
        divisors.remove(divisors.size() - 1);
        return divisors.stream()
                .reduce(0, Integer::sum).equals(value);
    }

    /**
     * Finds the prime factors of a given integer.
     *
     * @param value the integer for which to find prime factors
     * @return an array containing the prime factors of the given integer
     */
    static List<Integer> toPrimeFactors(int value) {
        var factors = new ArrayList<Integer>();
        for (int i = 2; i * i <= value; i++) {
            while (value % i == 0 && isPrime(i)) {
                factors.add(i);
                value /= i;
            }
        }
        if (value > 1) {
            factors.add(value);
        }
        return factors;
    }

    /**
     * Calculates the number of common divisors between two given integers.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the number of common divisors between the two integers
     */

    static int commonDivisorsCounter(int a, int b, Gcd gcd, boolean zeroAndNumIncluded) {
        if (a == 0 && b == 0) {
            return Integer.MAX_VALUE;
        } else if (a == 0 || b == 0) {
            return a == 0 ? countDivisors(b, zeroAndNumIncluded) : countDivisors(a, zeroAndNumIncluded);
        }
        var countedGcd = gcd.nwd(a, b);
        if (countedGcd == 1) {
            return countedGcd;
        }
        return countDivisors(countedGcd, zeroAndNumIncluded);
    }

    /**
     * Computes non-common divisors of two integers.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return A list containing the non-common divisors of the two integers.
     */
    static List<Integer> nonCommonDivisorsCounter(int a, int b) {
        if (a == b) {
            return Collections.emptyList();
        } else if (a == 0 || b == 0) {
            return a == 0 ? getDivisors(b) : getDivisors(a);
        }
        var divA = getDivisors(a);
        var divB = getDivisors(b);
        return Stream.concat(
                        divA.stream()
                                .filter(e -> !divB.contains(e)),
                        divB.stream()
                                .filter(e -> !divA.contains(e))
                )
                .sorted(Comparator.naturalOrder())
                .toList();
    }

    /**
     * Computes the divisors of an integer.
     *
     * @param a The integer for which divisors are to be computed.
     * @return A list containing the divisors of the given integer.
     */

    static List<Integer> getDivisors(int a) {
        var divisors = new ArrayList<>(List.of(1));
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                divisors.add(i);
                if (i != a / i) {
                    divisors.add(a / i);
                }
            }
        }
        divisors.add(a);
        divisors.sort(Comparator.naturalOrder());
        return divisors;
    }


    /**
     * Checks if two integers are relatively prime.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return True if the two integers are relatively prime, false otherwise.
     */
    public static boolean areRelativelyPrime(int a, int b, Gcd gcd) {
        return gcd.nwd(a, b) == 1;
    }
}
