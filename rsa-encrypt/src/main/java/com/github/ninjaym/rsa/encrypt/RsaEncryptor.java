package com.github.ninjaym.rsa.encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RsaEncryptor {
    private static Cipher encryptCipher;
    static {
        try {
            byte[] publicKeyBytes = Files.readAllBytes(Paths.get(RsaEncryptor.class.getClassLoader().getResource("rsa_key.pub").toURI()));
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String encrypt(String content) throws IllegalBlockSizeException, BadPaddingException {
        byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedContentBytes = encryptCipher.doFinal(contentBytes);
        return Base64.getEncoder().encodeToString(encryptedContentBytes);
    }
}
