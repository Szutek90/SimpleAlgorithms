package com.app.algorithm.text;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PatternSearchTest {

    @Test
    @DisplayName("when given text fit pattern")
    void test() {
        var patternMatcher = new PatternSearch("^([A-Z][a-z]){1,}(\\d)$");
        Assertions.assertThat(patternMatcher.searchPattern("EfGh5")).isTrue();
    }
}
