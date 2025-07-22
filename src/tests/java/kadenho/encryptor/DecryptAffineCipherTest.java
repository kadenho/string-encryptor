package kadenho.encryptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DecryptAffineCipherTest {
    @Test
    public void lowercaseTextMultiplicativeOneAdditiveOne() {
        String ciphertext = "qmfbtffodszquuijt";
        String[] expectedOutput = {"pleaseencryptthis", "1", "1"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 1, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMultiplicativeOneAdditiveOne() {
        String ciphertext = "UijtJtTfotjujwfJogpsnbujpo";
        String[] expectedOutput = {"ThisIsSensitiveInformation", "1", "1"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 1, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMultiplicativeOneAdditiveOne() {
        String ciphertext = "uijt nvtu opu cf mfblfe";
        String[] expectedOutput = {"this must not be leaked", "1", "1"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 1, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMultiplicativeOneAdditiveOne() {
        String ciphertext = "tfdsfu jogpsnbujpo ifsf";
        String[] expectedOutput = {"secret information here", "1", "1"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 1, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixcharTextMultiplicativeOneAdditiveOne() {
        String ciphertext = "opcpez dbo lopx uijt.";
        String[] expectedOutput = {"nobody can know this.", "1", "1"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 1, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixcharTextMultiplicativeOneAdditiveOne() {
        String ciphertext = "Ifz! Epo'u ufmm bozcpez.";
        String[] expectedOutput = {"Hey! Don't tell anybody.", "1", "1"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 1, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextMultiplicativeOneAdditiveEleven() {
        String ciphertext = "awpldppyncjaeestd";
        String[] expectedOutput = {"pleaseencryptthis", "1", "11"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 1, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMultiplicativeOneAdditiveEleven() {
        String ciphertext = "EstdTdDpydtetgpTyqzcxletzy";
        String[] expectedOutput = {"ThisIsSensitiveInformation", "1", "11"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 1, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMultiplicativeOneAdditiveEleven() {
        String ciphertext = "estd xfde yze mp wplvpo";
        String[] expectedOutput = {"this must not be leaked", "1", "11"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 1, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMultiplicativeOneAdditiveEleven() {
        String ciphertext = "dpncpe tyqzcxletzy spcp";
        String[] expectedOutput = {"secret information here", "1", "11"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 1, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixcharTextMultiplicativeOneAdditiveEleven() {
        String ciphertext = "yzmzoj nly vyzh estd.";
        String[] expectedOutput = {"nobody can know this.", "1", "11"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 1, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixcharTextMultiplicativeOneAdditiveEleven() {
        String ciphertext = "Spj! Ozy'e epww lyjmzoj.";
        String[] expectedOutput = {"Hey! Don't tell anybody.", "1", "11"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 1, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextMultiplicativeElevenAdditiveEleven() {
        String ciphertext = "ucdlbddyhqpummkvb";
        String[] expectedOutput = {"pleaseencryptthis", "11", "11"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 11, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMultiplicativeElevenAdditiveEleven() {
        String ciphertext = "MkvbVbBdybvmvidVyojqnlmvjy";
        String[] expectedOutput = {"ThisIsSensitiveInformation", "11", "11"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 11, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMultiplicativeElevenAdditiveEleven() {
        String ciphertext = "mkvb nxbm yjm wd cdlrds";
        String[] expectedOutput = {"this must not be leaked", "11", "11"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 11, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMultiplicativeElevenAdditiveEleven() {
        String ciphertext = "bdhqdm vyojqnlmvjy kdqd";
        String[] expectedOutput = {"secret information here", "11", "11"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 11, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixcharTextMultiplicativeElevenAdditiveEleven() {
        String ciphertext = "yjwjsp hly ryjt mkvb.";
        String[] expectedOutput = {"nobody can know this.", "11", "11"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 11, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixcharTextMultiplicativeElevenAdditiveEleven() {
        String ciphertext = "Kdp! Sjy'm mdcc lypwjsp.";
        String[] expectedOutput = {"Hey! Don't tell anybody.", "11", "11"};
        String[] actualOutput = StringEncryptor.decryptAffineCipher(ciphertext, 11, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }
}
