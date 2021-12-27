package com.github.ninjaym.rsa.encrypt;

import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class RsaEncryptorTest {

    @Test
    public void testEncrypt() throws IllegalBlockSizeException, BadPaddingException {
        String input = "hello world, 你好, 世界";
        String output = RsaEncryptor.encrypt(input);
        assert output != null;
    }

}
