package com.app.algorithm.encyption_compression;

import com.app.algorithm.encryption_compression.CeaserCipher;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CeaseCipherTest {
    private static CeaserCipher cipher;

    @BeforeAll
    static void beforeAll() {
        cipher = new CeaserCipher(5);
    }


    @ParameterizedTest
    @CsvSource({
            "HELLO, MJQQT",
            "XYZ, CDE",
            "hello, mjqqt",
            "HeLlO, MjQqT",
            "Hello World!, Mjqqt Btwqi!",
    })
    @DisplayName("When encrypt is correct")
    void test1(String input, String expected) {
        Assertions.assertThat(cipher.encrypt(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "HELLO, MJQQT",
            "XYZ, CDE",
            "hello, mjqqt",
            "HeLlO, MjQqT",
            "Hello World!, Mjqqt Btwqi!",
    })
    @DisplayName("When decrypt is correct")
    void test2(String expected, String input) {
        Assertions.assertThat(cipher.decrypt(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("When encrypt is not correct")
    void test3() {
        Assertions.assertThat(cipher.encrypt("Simba")).isNotEqualTo("xyzaa");
    }

    @Test
    @DisplayName("When decrypt is not correct")
    void test4() {
        Assertions.assertThat(cipher.decrypt("Xnrgf")).isNotEqualTo("Lili");
    }
}
