package com.app.algorithm.encryption_compression;

/**
 * The InversionCipher class provides methods for encrypting and decrypting text using the Inversion Cipher algorithm.
 */

public class InversionCipher {

    private final int key;

    /**
     * Constructs an InversionCipher object with the specified key.
     *
     * @param key The key to be used for encryption and decryption.
     */
    public InversionCipher(int key) {
        this.key = key;
    }

    /**
     * Encrypts the given plain text using the Inversion Cipher algorithm.
     *
     * @param plainText The plain text to be encrypted.
     * @return The encrypted text.
     */

    public String encrypt(String plainText) {
        var sb = new StringBuilder();
        var chars = plainText.toCharArray();
        var length = chars.length;
        for (int i = 0; i < length; i++) {
            var idx = (i + key) % length;
            idx = (i + key) % length < 0 ? idx + length : idx;
            sb.append(chars[idx]);
        }
        return sb.toString();
    }

    /**
     * Decrypts the given cipher text using the Inversion Cipher algorithm.
     *
     * @param cipherText The cipher text to be decrypted.
     * @return The decrypted text.
     */

    public String decrypt(String cipherText) {
        var sb = new StringBuilder();
        var chars = cipherText.toCharArray();
        var length = chars.length;
        for (int i = 0; i < length; i++) {
            sb.append(chars[(i - key + length) % length]);
        }
        return sb.toString();
    }
}
