package com.app.algorithm.numbers.gcd.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecursiveGcdTest {

    @Test
    @DisplayName("when nwd from two values are correct")
    void test1(){
        var gcd = new RecursiveGcd();
        Assertions.assertThat(gcd.nwd(56,48)).isEqualTo(8);
    }
}