package com.app.algorithm.encyption_compression;

import com.app.algorithm.encryption_compression.Rsa;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PublicKey;

class RsaTest {
    private static Rsa rsa;
    private static PublicKey publicKey;
    private static Path pathTofile;
    private static String filename;

    @BeforeAll
    static void beforeAll() {
        rsa = new Rsa();
        publicKey = rsa.publicKey;
        filename = "testRsaFile.csv";
        pathTofile = Paths.get(System.getProperty("user.dir"), filename);
    }

    @Test
    @DisplayName("when encyrption and decryption is correct")
    void test1() {
        var textToEncrypt = "Sim1ba i li$li";
        var encrypted = rsa.encrypt(textToEncrypt, publicKey);
        var decrypted = rsa.decrypt(encrypted);
        Assertions.assertThat(decrypted).isEqualTo(textToEncrypt);
    }

    @Test
    @DisplayName("when encyrption and decryption is not correct")
    void test2() {
        var textToEncrypt = "Sim1ba i li$li";
        var encrypted = rsa.encrypt(textToEncrypt, publicKey);
        var decrypted = rsa.decrypt(encrypted);
        Assertions.assertThat(decrypted).isNotEqualTo("wrong");
    }

    @Test
    @DisplayName("when saved file is not null or empty")
    void test3() {
        rsa.savePublicKeyToFile(filename);
        try {
            Assertions.assertThat(Files.size(pathTofile)).isPositive();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    @SneakyThrows
    static void afterAll() {
        Files.delete(pathTofile);
    }
}
