package com.thanos.secure_book_api_v2;

import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;

public class GenerateSecretKeyTest {

    @Test
    public void generateSecretKey() {
        SecretKey key = Jwts.SIG.HS256.key().build();
        String encodedKey = DatatypeConverter.printHexBinary(key.getEncoded());
        System.out.printf("\nKey = [%s]\n", encodedKey);
    }
}
