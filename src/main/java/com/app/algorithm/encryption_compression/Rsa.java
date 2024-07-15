package com.app.algorithm.encryption_compression;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;

/**
 * The Rsa class provides methods for RSA encryption and decryption.
 */

public class Rsa {

    private final PrivateKey privateKey;
    public final PublicKey publicKey;

    /**
     * Constructs an instance of the Rsa class and generates a new RSA key pair.
     * The generated private and public keys are stored internally.
     * If an error occurs during key pair generation, it throws an IllegalStateException.
     */

    public Rsa() {
        try {
            KeyPair keyPair = generateKeyPair();
            this.privateKey = keyPair.getPrivate();
            this.publicKey = keyPair.getPublic();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Encrypts the given plaintext using the provided public key.
     *
     * @param plainText The plaintext to encrypt.
     * @param publicKey The public key used for encryption.
     * @return The encrypted ciphertext as a byte array.
     * @throws IllegalStateException If an error occurs during encryption.
     */

    public byte[] encrypt(String plainText, PublicKey publicKey) {
        try {
            var encryptCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return encryptCipher.doFinal(plainText.getBytes());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Decrypts the given ciphertext using the internally stored private key.
     *
     * @param cipherText The ciphertext to decrypt.
     * @return The decrypted plaintext as a String.
     * @throws IllegalStateException If an error occurs during decryption.
     */

    public String decrypt(byte[] cipherText) {
        try {
            var decryptCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
            return new String(decryptCipher.doFinal(cipherText), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Saves the internally stored public key to a file.
     *
     * @param filename The name of the file to save the public key to.
     * @throws IllegalStateException If an error occurs during file writing.
     */

    public void savePublicKeyToFile(String filename) {
        try{
            Files.write(Paths.get(filename), publicKey.getEncoded());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Generates a new RSA key pair with a key size of 2048 bits.
     *
     * @return The generated KeyPair containing the private and public keys.
     * @throws IllegalStateException If an error occurs during key pair generation.
     */

    private KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            SecureRandom secureRandom = new SecureRandom();
            keyPairGenerator.initialize(2048, secureRandom);
            return keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
