package kadenho.encryptor;

import org.jetbrains.annotations.NotNull;
import static kadenho.encryptor.CipherUtils.UNSCRAMBLED_ALPHABET;

public class CaesarCipher {
    public static String[] encrypt(String plaintext, int shiftKey) {
        StringBuilder ciphertextStringBuilder = new StringBuilder();
        return shiftString(plaintext, shiftKey, ciphertextStringBuilder, shiftKey);
    }

    public static String[] decrypt(String ciphertext, int shiftKey) {
        StringBuilder plaintextStringBuilder = new StringBuilder();
        int offsetShift = UNSCRAMBLED_ALPHABET.length() - shiftKey;
        return shiftString(ciphertext, shiftKey, plaintextStringBuilder, offsetShift);
    }

    @NotNull
    private static String[] shiftString(String ciphertext, int shiftKey, StringBuilder plaintextStringBuilder, int offsetShift) {
        for (char character : ciphertext.toCharArray()) {
            int characterIndex = UNSCRAMBLED_ALPHABET.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                char scrambledCharacter = UNSCRAMBLED_ALPHABET.charAt((characterIndex + offsetShift) % UNSCRAMBLED_ALPHABET.length());
                if (Character.isUpperCase(character)) {
                    scrambledCharacter = Character.toUpperCase(scrambledCharacter);
                }
                plaintextStringBuilder.append(scrambledCharacter);
            } else {
                plaintextStringBuilder.append(character);
            }
        }
        String plaintext = plaintextStringBuilder.toString();
        return new String[]{plaintext, Integer.toString(shiftKey)};
    }

}

