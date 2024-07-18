package com.app.algorithm.text;

import java.util.regex.Pattern;

/**
 * The PatternSearch class provides methods for searching a pattern in a text using regular expressions.
 */

public class PatternSearch {

    /** The compiled pattern to search for. */
    private final Pattern pattern;

    /**
     * Constructs a PatternSearch object with the specified pattern.
     *
     * @param pattern the regular expression pattern to search for
     */

    public PatternSearch(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    /**
     * Searches for the pattern in the given text.
     *
     * @param text the text in which to search for the pattern
     * @return true if the pattern is found in the text, otherwise false
     */

    public boolean searchPattern(String text) {
        return pattern.matcher(text).find();
    }
}
