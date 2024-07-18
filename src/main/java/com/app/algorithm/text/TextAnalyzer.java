package com.app.algorithm.text;

import java.util.Arrays;

/**
 * The TextAnalyzer interface provides static methods for analyzing text, such as checking for palindromes and anagrams.
 */

public interface TextAnalyzer {
    /**
     * Checks if a given text is a palindrome.
     *
     * @param text the text to check
     * @return true if the text is a palindrome, false otherwise
     */

    static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
        var chars = text.toCharArray();
        var j = chars.length - 1;
        var i = 0;

        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * Checks if two given texts are anagrams of each other.
     *
     * @param text1 the first text
     * @param text2 the second text
     * @return true if the texts are anagrams, false otherwise
     */

    static boolean areAnagrams(String text1, String text2) {
        text1 = text1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        text2 = text2.replaceAll("[^a-zA-Z]", "").toLowerCase();
        if (text1.length() != text2.length()) {
            return false;
        }
        var chars1 = text1.toCharArray();
        var chars2 = text2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }
}
