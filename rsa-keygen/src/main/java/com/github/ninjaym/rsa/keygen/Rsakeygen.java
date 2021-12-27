package com.github.ninjaym.rsa.keygen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

public class Rsakeygen {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();

        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        try (FileOutputStream fos = new FileOutputStream("rsa_key.pub")) {
            fos.write(publicKey.getEncoded());
        }

        try (FileOutputStream fos = new FileOutputStream("rsa_key")) {
            fos.write(privateKey.getEncoded());
        }
    }
}
