package com.app.algorithm.encyption_compression;

import com.app.algorithm.encryption_compression.MorseCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MorseCodeTest {
    private static MorseCode morseCode;

    @BeforeAll
    static void beforeAll() {
        morseCode = new MorseCode();
    }

    @ParameterizedTest
    @CsvSource({
            "SIMBA, ... .. -- -... .- ",
            "XYZ,  -..- -.-- --.. ",
            "HELLO, .... . .-.. .-.. ---",
            "HELLO WORLD, .... . .-.. .-.. --- / .-- --- .-. .-.. -..",
    })
    @DisplayName("When encrypt is correct")
    void test1(String input, String expected) {
        Assertions.assertThat(morseCode.encrypt(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "SIMBA, ... .. -- -... .- ",
            "XYZ,  -..- -.-- --.. ",
            "HELLO, .... . .-.. .-.. ---",
            "HELLO WORLD, .... . .-.. .-.. --- / .-- --- .-. .-.. -..",
    })
    @DisplayName("When decrypt is correct")
    void test2(String expected, String input) {
        Assertions.assertThat(morseCode.decrypt(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("When encrypt is not correct")
    void test3() {
        Assertions.assertThat(morseCode.encrypt("Simba")).isNotEqualTo(".... . .-.. .-.. ---");
    }

    @Test
    @DisplayName("When decrypt is not correct")
    void test4() {
        Assertions.assertThat(morseCode.decrypt("Xnrgf")).isNotEqualTo(".... . .-.. .-.. ---");
    }
}
