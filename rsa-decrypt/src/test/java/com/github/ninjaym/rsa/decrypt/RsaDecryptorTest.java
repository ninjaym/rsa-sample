package com.github.ninjaym.rsa.decrypt;

import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class RsaDecryptorTest {

    @Test
    public void testDecrypt() throws IllegalBlockSizeException, BadPaddingException {
        String input = "El0AkMDa4QJxItuFySx6bEVmLyNq4WloHp3Cj2djNNPJRVt9wWmp4HPisfK3K1s/anbgwwmUDvmPFp4uPZrDjnkP1THIJwyJirmf90TlLhuCAQBdntp6UBFp2cjii/OohfoljWeSDSJOo6U2ycmyJdBg4hXRYTDyoeWCREz/syRyHGFvzSxyGMdcdEetsUAF7oChchQgK2PqP7m26UlSNrizbIo5n3jhQ8PBZM4SqVL0tKFnMWP4V6fb1lmf2TpDWBMS2EKDIcQzbdjVZBOdDpsb+r8DKASuGe7Dm2/XLfaX0vl8tbqonrB65lNk2avXskqeSWhVcaQCkuN9aVwrtg==";
        String output = RsaDecryptor.decrypt(input);

        assert output != null;
        assert output.equals("hello world, 你好, 世界");
    }
}
