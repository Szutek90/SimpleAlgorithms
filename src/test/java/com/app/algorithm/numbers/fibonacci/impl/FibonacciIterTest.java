package com.app.algorithm.numbers.fibonacci.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FibonacciIterTest {
    static FibonacciIter fib;

    @BeforeAll
    static void beforeAll(){
        fib = new FibonacciIter();
    }


    @Test
    @DisplayName("when fibonacci is correct")
    void test1(){
        Assertions.assertThat(fib.getSequence(11)).isEqualTo(89);
    }

    @Test
    @DisplayName("when fibonacci sequence is lower than 3")
    void test2(){
        Assertions.assertThat(fib.getSequence(2)).isEqualTo(1);
    }

}
