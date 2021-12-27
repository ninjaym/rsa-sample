package com.github.ninjaym.rsa.decrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class RsaDecryptor {
    private static Cipher decryptCipher;

    static {
        try {
            byte[] privateKeyBytes = Files.readAllBytes(Paths.get(RsaDecryptor.class.getClassLoader().getResource("rsa_key").toURI()));
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
            decryptCipher = Cipher.getInstance("RSA");
            decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String decrypt(String content) throws IllegalBlockSizeException, BadPaddingException {
        byte[] contentBytes = Base64.getDecoder().decode(content);
        byte[] decryptedContentBytes = decryptCipher.doFinal(contentBytes);
        return new String(decryptedContentBytes, StandardCharsets.UTF_8);
    }
}
