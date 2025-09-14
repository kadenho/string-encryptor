package kadenho.ciphers;

import static kadenho.ciphers.CipherUtils.UNSCRAMBLED_ALPHABET;
import static kadenho.ciphers.CipherUtils.convertAlphabets;

public class MixedAlphabetCipher {
    public static String[] encrypt(String plaintext, String keyString) {
        String scrambledAlphabet = buildMixedAlphabet(keyString);
        String ciphertext = convertAlphabets(plaintext, UNSCRAMBLED_ALPHABET, scrambledAlphabet);
        return new String[]{ciphertext, keyString};
    }

    public static String[] decrypt(String ciphertext, String keyString) {

        String scrambledAlphabet = buildMixedAlphabet(keyString);
        String plaintext = convertAlphabets(ciphertext, scrambledAlphabet, UNSCRAMBLED_ALPHABET);
        return new String[]{plaintext, keyString};
    }

    private static String buildMixedAlphabet(String keyString) {
        StringBuilder scrambledAlphabetStringBuilder = new StringBuilder();
        for (char character : keyString.toCharArray()) {
            if (scrambledAlphabetStringBuilder.indexOf(String.valueOf(Character.toLowerCase(character))) == -1) {
                scrambledAlphabetStringBuilder.append(Character.toLowerCase(character));
            }
        }
        for (char character : UNSCRAMBLED_ALPHABET.toCharArray()) {
            if (scrambledAlphabetStringBuilder.indexOf(String.valueOf(Character.toLowerCase(character))) == -1) {
                scrambledAlphabetStringBuilder.append(Character.toLowerCase(character));
            }
        }
        return scrambledAlphabetStringBuilder.toString();
    }
}
