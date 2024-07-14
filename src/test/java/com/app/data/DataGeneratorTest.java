package com.app.data;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DataGeneratorTest {

    @Test
    @DisplayName("when generating random int")
    void test1() {
        Assertions.assertThat(DataGenerator.getRandomInt()).isBetween(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Test
    @DisplayName("when generating random int with range")
    void test2() {
        Assertions.assertThat(DataGenerator.getRandomIntWithRange(5, 10)).isBetween(5, 10);
    }

    @Test
    @DisplayName("when generating random double with range and precision")
    void test3() {
        var rndDblValue = DataGenerator.getRandomDblWithRange(1.2, 10.3, 2);
        Assertions.assertThat(rndDblValue).isBetween(1.2, 10.3)
                .isEqualTo(Math.round(rndDblValue * Math.pow(10, 2)) / Math.pow(10, 2));
    }

    @Test
    @DisplayName("when precision is wrong")
    void test4() {
        Assertions.assertThatThrownBy(() ->
                DataGenerator.getRandomDblWithRange(1.2, 10.3, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Precision should be greater than zero");
    }

    @Test
    @DisplayName("when min is higher than max")
    void test5() {
        Assertions.assertThatThrownBy(() ->
                DataGenerator.getRandomIntWithRange(8, 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("max must be greater than min");
    }
}