package com.app.algorithm.encyption_compression;

import com.app.algorithm.encryption_compression.InversionCipher;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InversionCipherTest {
    private static InversionCipher cipher;

    @BeforeAll
    static void beforeAll() {
        cipher = new InversionCipher(3);
    }

    @ParameterizedTest
    @CsvSource({
            "SIMBA, BASIM",
            "XYZ, XYZ",
            "hello, lohel",
            "HeLlO, lOHeL",
            "Hello World!, lo World!Hel",
    })
    @DisplayName("When encrypt is correct")
    void test1(String input, String expected) {
        Assertions.assertThat(cipher.encrypt(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "SIMBA, BASIM",
            "XYZ, XYZ",
            "hello, lohel",
            "HeLlO, lOHeL",
            "Hello World!, lo World!Hel",
    })
    @DisplayName("When decrypt is correct")
    void test2(String expected, String input) {
        Assertions.assertThat(cipher.decrypt(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("When encrypt is not correct")
    void test3() {
        Assertions.assertThat(cipher.encrypt("Simba")).isNotEqualTo("bmsia");
    }

    @Test
    @DisplayName("When decrypt is not correct")
    void test4() {
        Assertions.assertThat(cipher.decrypt("Xnrgf")).isNotEqualTo("Lili");
    }
}
