package kadenho.encryptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class EncryptAffineCipherTest {
    @Test
    public void lowercaseTextMultiplicativeOneAdditiveOne() {
        String plaintext = "pleaseencryptthis";
        String[] expectedOutput = {"qmfbtffodszquuijt", "1", "1"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 1, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMultiplicativeOneAdditiveOne() {
        String plaintext = "ThisIsSensitiveInformation";
        String[] expectedOutput = {"UijtJtTfotjujwfJogpsnbujpo", "1", "1"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 1, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMultiplicativeOneAdditiveOne() {
        String plaintext = "this must not be leaked";
        String[] expectedOutput = {"uijt nvtu opu cf mfblfe", "1", "1"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 1, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMultiplicativeOneAdditiveOne() {
        String plaintext = "secret information here";
        String[] expectedOutput = {"tfdsfu jogpsnbujpo ifsf", "1", "1"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 1, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixcharTextMultiplicativeOneAdditiveOne() {
        String plaintext = "nobody can know this.";
        String[] expectedOutput = {"opcpez dbo lopx uijt.", "1", "1"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 1, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixcharTextMultiplicativeOneAdditiveOne() {
        String plaintext = "Hey! Don't tell anybody.";
        String[] expectedOutput = {"Ifz! Epo'u ufmm bozcpez.", "1", "1"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 1, 1);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextMultiplicativeOneAdditiveEleven() {
        String plaintext = "pleaseencryptthis";
        String[] expectedOutput = {"awpldppyncjaeestd", "1", "11"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 1, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMultiplicativeOneAdditiveEleven() {
        String plaintext = "ThisIsSensitiveInformation";
        String[] expectedOutput = {"EstdTdDpydtetgpTyqzcxletzy", "1", "11"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 1, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMultiplicativeOneAdditiveEleven() {
        String plaintext = "this must not be leaked";
        String[] expectedOutput = {"estd xfde yze mp wplvpo", "1", "11"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 1, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMultiplicativeOneAdditiveEleven() {
        String plaintext = "secret information here";
        String[] expectedOutput = {"dpncpe tyqzcxletzy spcp", "1", "11"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 1, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixcharTextMultiplicativeOneAdditiveEleven() {
        String plaintext = "nobody can know this.";
        String[] expectedOutput = {"yzmzoj nly vyzh estd.", "1", "11"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 1, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixcharTextMultiplicativeOneAdditiveEleven() {
        String plaintext = "Hey! Don't tell anybody.";
        String[] expectedOutput = {"Spj! Ozy'e epww lyjmzoj.", "1", "11"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 1, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseTextMultiplicativeElevenAdditiveEleven() {
        String plaintext = "pleaseencryptthis";
        String[] expectedOutput = {"ucdlbddyhqpummkvb", "11", "11"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 11, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseTextMultiplicativeElevenAdditiveEleven() {
        String plaintext = "ThisIsSensitiveInformation";
        String[] expectedOutput = {"MkvbVbBdybvmvidVyojqnlmvjy", "11", "11"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 11, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedTextMultiplicativeElevenAdditiveEleven() {
        String plaintext = "this must not be leaked";
        String[] expectedOutput = {"mkvb nxbm yjm wd cdlrds", "11", "11"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 11, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedTextMultiplicativeElevenAdditiveEleven() {
        String plaintext = "secret information here";
        String[] expectedOutput = {"bdhqdm vyojqnlmvjy kdqd", "11", "11"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 11, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void lowercaseSpacedMixcharTextMultiplicativeElevenAdditiveEleven() {
        String plaintext = "nobody can know this.";
        String[] expectedOutput = {"yjwjsp hly ryjt mkvb.", "11", "11"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 11, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mixcaseSpacedMixcharTextMultiplicativeElevenAdditiveEleven() {
        String plaintext = "Hey! Don't tell anybody.";
        String[] expectedOutput = {"Kdp! Sjy'm mdcc lypwjsp.", "11", "11"};
        String[] actualOutput = StringEncryptor.encryptAffineCipher(plaintext, 11, 11);
        assertArrayEquals(expectedOutput, actualOutput);
    }
}
