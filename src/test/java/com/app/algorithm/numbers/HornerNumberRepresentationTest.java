package com.app.algorithm.numbers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HornerNumberRepresentationTest {

    @Test
    @DisplayName("when base is 16")
    void test1(){
        Assertions.assertThat(HornerNumberRepresentation.evaluatePolynomial(255,16))
                .isEqualTo("FF");
    }

    @Test
    @DisplayName("when base is out of range")
    void test2(){
        Assertions.assertThatThrownBy(() ->
                HornerNumberRepresentation.evaluatePolynomial(255,18))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Base out of range");
    }
}
