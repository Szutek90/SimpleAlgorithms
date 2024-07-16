package com.app.algorithm.numbers;

import com.app.algorithm.numbers.gcd.impl.EuclideanGcd;
import com.app.algorithm.numbers.gcd.impl.RecursiveGcd;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleAlgorithmsTest {

    @Test
    @DisplayName("when value is prime")
    void test1() {
        assertThat(SimpleAlgorithms.isPrime(29)).isTrue();
    }

    @Test
    @DisplayName("when counting divisors")
    void test2() {
        assertThat(SimpleAlgorithms.countDivisors(138, false)).isEqualTo(8);
    }

    @Test
    @DisplayName("when value is perfect")
    void test3() {
        assertThat(SimpleAlgorithms.isPerfect(28)).isTrue();
    }

    @Test
    @DisplayName("when breaking into prime factors")
    void test4() {
        assertThat(SimpleAlgorithms.toPrimeFactors(12)).containsExactly(2, 2, 3);
    }

    @Test
    @DisplayName("when getting common divisors")
    void test5() {
        assertThat(SimpleAlgorithms
                .commonDivisorsCounter(20, 40, new EuclideanGcd(), false))
                .isEqualTo(6);
    }

    @Test
    @DisplayName("when getting non common divisors")
    void test6() {
        assertThat(SimpleAlgorithms
                .nonCommonDivisorsCounter(18, 20)).containsExactly(3, 4, 5, 6, 9, 10, 18, 20);
    }

    @Test
    @DisplayName("when getting divisors")
    void test7() {
        assertThat(SimpleAlgorithms.getDivisors(12)).containsExactly(1, 2, 3, 4, 6, 12);
    }

    @Test
    @DisplayName("when are relatively prime")
    void test8() {
        assertThat(SimpleAlgorithms.areRelativelyPrime(25, 38, new RecursiveGcd())).isTrue();
    }

    @ParameterizedTest
    @DisplayName("when value is not prime")
    @ValueSource(ints = {-1, 49, 12})
    void test9(int value) {
        assertThat(SimpleAlgorithms.isPrime(value)).isFalse();
    }

    @Test
    @DisplayName("when getting non common divisors with the same values")
    void test10() {
        assertThat(SimpleAlgorithms
                .nonCommonDivisorsCounter(18, 18)).isEmpty();
    }

    @Test
    @DisplayName("when getting non common divisors with one zero value")
    void test11() {
        assertThat(SimpleAlgorithms
                .nonCommonDivisorsCounter(18, 0)).containsExactly(1, 2, 3, 6, 9, 18);
    }

    @Test
    @DisplayName("when getting common divisors from two zeros")
    void test12() {
        assertThat(SimpleAlgorithms
                .commonDivisorsCounter(0, 0, new EuclideanGcd(), false))
                .isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    @DisplayName("when getting common divisors with one zero")
    void test13() {
        assertThat(SimpleAlgorithms
                .commonDivisorsCounter(0, 12, new EuclideanGcd(), false))
                .isEqualTo(6);
    }


    @Test
    @DisplayName("when counting divisors at value 0")
    void test14() {
        assertThat(SimpleAlgorithms.countDivisors(0, false))
                .isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    @DisplayName("when counting divisors at negative value -18")
    void test15() {
        assertThat(SimpleAlgorithms.countDivisors(-18, false))
                .isEqualTo(12);
    }
}
