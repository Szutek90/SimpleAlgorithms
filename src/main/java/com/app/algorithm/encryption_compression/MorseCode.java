package com.app.algorithm.encryption_compression;

import java.util.HashMap;
import java.util.Map;

/**
 * The MorseCode class provides methods to encrypt and decrypt text using Morse code.
 * It contains a HashMap that maps characters to their Morse code representations.
 */

public class MorseCode {
    protected final HashMap<Character, String> morseCodeMap;

    /**
     * Constructs a MorseCode object and initializes the Morse code map.
     * The map contains mappings of characters to their corresponding Morse code representations.
     */

    public MorseCode() {
        morseCodeMap = new HashMap<>(Map.ofEntries(Map.entry('A', ".-"), Map.entry('B', "-..."),
                Map.entry('C', "-.-."), Map.entry('D', "-.."), Map.entry('E', "."), Map.entry('F', "..-."),
                Map.entry('G', "--."), Map.entry('H', "...."), Map.entry('I', ".."), Map.entry('J', ".---"),
                Map.entry('K', "-.-"), Map.entry('L', ".-.."), Map.entry('M', "--"), Map.entry('N', "-."),
                Map.entry('O', "---"), Map.entry('P', ".--."), Map.entry('R', ".-."), Map.entry('S', "..."),
                Map.entry('T', "-"), Map.entry('U', "..-"), Map.entry('V', "...-"), Map.entry('W', ".--"),
                Map.entry('X', "-..-"), Map.entry('Y', "-.--"), Map.entry('Z', "--.."),
                Map.entry('0', "-----"), Map.entry('1', ".----"), Map.entry('2', "..---"),
                Map.entry('3', "...--"), Map.entry('4', "....-"), Map.entry('5', "....."),
                Map.entry('6', "-...."), Map.entry('7', "--..."), Map.entry('8', "---.."),
                Map.entry('9', "----."), Map.entry(' ', "/")
        ));
    }

    /**
     * Decrypts Morse code to plain text.
     *
     * @param text The Morse code to decrypt.
     * @return The decrypted plain text.
     */

    public String decrypt(String text) {
        var splitted = text.split(" ");
        var sb = new StringBuilder();
        for (String s : splitted) {
            if (morseCodeMap.containsValue(s)) {
                for (var entry : morseCodeMap.entrySet()) {
                    if (s.equals(entry.getValue())) {
                        sb.append(entry.getKey());
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * Encrypts plain text to Morse code.
     *
     * @param text The plain text to encrypt.
     * @return The encrypted Morse code.
     */

    public String encrypt(String text) {
        var sb = new StringBuilder();
        for (var ch : text.toUpperCase().toCharArray()) {
            if (morseCodeMap.containsKey(ch)) {
                sb.append(" ").append(morseCodeMap.get(ch));
            }
        }
        return sb.toString().replaceFirst(" ", "");
    }
}