package com.app.algorithm.text;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TextAnalyzerTest {

    @Test
    @DisplayName("when text is palindrome")
    void test1() {
        Assertions.assertThat(TextAnalyzer.isPalindrome("kajak")).isTrue();
    }

    @Test
    @DisplayName("when texts are anagrams")
    void test2() {
        Assertions.assertThat(TextAnalyzer.areAnagrams("bard", "drab")).isTrue();
    }
}
