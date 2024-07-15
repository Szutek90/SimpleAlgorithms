package com.app.algorithm.encryption_compression;

/**
 * The CeaserCipher class provides methods for encrypting and decrypting text using the Caesar Cipher algorithm.
 */
public class CeaserCipher {
    private final int key;

    /**
     * Constructs a CeaserCipher object with the specified key.
     *
     * @param key The key to be used for encryption and decryption.
     */

    public CeaserCipher(int key) {
        this.key = key % 26;
    }

    /**
     * Encrypts the given plain text using the Caesar Cipher algorithm.
     *
     * @param plainText The plain text to be encrypted.
     * @return The encrypted text.
     */

    public String encrypt(String plainText) {
        var chars = plainText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = getCharacter(chars[i], key);
        }
        return String.valueOf(chars);
    }

    /**
     * Decrypts the given cipher text using the Caesar Cipher algorithm.
     *
     * @param cipherText The cipher text to be decrypted.
     * @return The decrypted text.
     */

    public String decrypt(String cipherText) {
        var chars = cipherText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = getCharacter(chars[i], -key);
        }
        return String.valueOf(chars);
    }

    /**
     * Returns the character obtained by applying the Caesar Cipher algorithm to the given character.
     *
     * @param oldChar The original character.
     * @param key     The key for encryption or decryption.
     * @return The encrypted or decrypted character.
     */

    private char getCharacter(char oldChar, int key) {
        if (!Character.isLetter(oldChar)) {
            return oldChar; // Return unchanged if it's not a letter
        }

        char base = Character.isUpperCase(oldChar) ? 'A' : 'a';
        int offset = oldChar - base;
        int shiftedOffset = (offset + key + 26) % 26; // Ensure positive modulo
        return (char) (base + shiftedOffset);
    }
}
