package com.app.algorithm.numbers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

class NumberBaseConverterTest {
    static NumberBaseConverter converter;

    @BeforeAll
    static void beforeAll(){
        converter = new NumberBaseConverter(9);
    }

    @Test
    @DisplayName("when given value to convert to specified base")
    void test1(){
        Assertions.assertThat(converter.toUserSpecifiedBase(59)).isEqualTo("65");
    }

    @Test
    @DisplayName("when user specified range is correct")
    void test2(){
        Assertions.assertThat(converter.fromUserSpecifiedBase("1426562")).isEqualTo(785594);
    }

    @Test
    @DisplayName("when base is out of range")
    void test3(){
        Assertions.assertThatThrownBy(() -> new NumberBaseConverter(64))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("when user specified range is empty")
    void test4(String source){
        Assertions.assertThatThrownBy(() -> converter.fromUserSpecifiedBase(source))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
