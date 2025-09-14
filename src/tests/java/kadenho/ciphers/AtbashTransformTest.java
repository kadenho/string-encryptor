package kadenho.ciphers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AtbashTransformTest {
    @Test
    public void lowercaseText() {
        String plaintext = "culvers";
        String expectedOutput = "xfoevih";
        String actualOutput = AtbashTransform.encrypt(plaintext);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseText() {
        String plaintext = "Subway";
        String expectedOutput = "Hfydzb";
        String actualOutput = AtbashTransform.decrypt(plaintext);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedText() {
        String plaintext = "chick fil a";
        String expectedOutput = "xsrxp uro z";
        String actualOutput = AtbashTransform.encrypt(plaintext);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedText() {
        String plaintext = "Pizza Hut";
        String expectedOutput = "Kraaz Sfg";
        String actualOutput = AtbashTransform.decrypt(plaintext);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixcharText() {
        String plaintext = "domino's pizza";
        String expectedOutput = "wlnrml'h kraaz";
        String actualOutput = AtbashTransform.encrypt(plaintext);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixcharText() {
        String plaintext = "Raising Cane's.";
        String expectedOutput = "Izrhrmt Xzmv'h.";
        String actualOutput = AtbashTransform.decrypt(plaintext);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}
