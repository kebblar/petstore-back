package io.kebblar.petstore.api.utils;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JasyptTest {
    private static final Logger logger = LoggerFactory.getLogger(JasyptTest.class);

    @Test
    public void test() {
        String data="gustavo";
        String password = "password";

        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPasswordCharArray(password.toCharArray());
        String myEncryptedText = textEncryptor.encrypt(data);
        String plainText = textEncryptor.decrypt(myEncryptedText);
        logger.info(myEncryptedText);
        assertEquals(plainText, data);
    }
}
