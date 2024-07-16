package com.app.algorithm.numbers.fibonacci.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FibonacciRecTest {
    @Test
    @DisplayName("when fibonacci is correct")
    void test1(){
        var fib = new FibonacciRec();
        Assertions.assertThat(fib.getSequence(11)).isEqualTo(89);
    }
}
