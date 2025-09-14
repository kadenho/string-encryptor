package kadenho.ciphers;

import org.jetbrains.annotations.NotNull;

import static kadenho.ciphers.CipherUtils.UNSCRAMBLED_ALPHABET;

public class CaesarCipher {
    public static String[] encrypt(String plaintext, int shiftKey) {
        String ciphertext = shiftString(plaintext, shiftKey);
        return new String[]{ciphertext, Integer.toString(shiftKey)};
    }

    public static String[] decrypt(String ciphertext, int shiftKey) {
        int offsetShift = UNSCRAMBLED_ALPHABET.length() - shiftKey;
        String plaintext = shiftString(ciphertext, offsetShift);
        return new String[]{plaintext, Integer.toString(shiftKey)};
    }

    @NotNull
    private static String shiftString(String beforeText, int shiftKey) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char character : beforeText.toCharArray()) {
            int characterIndex = UNSCRAMBLED_ALPHABET.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                char scrambledCharacter = UNSCRAMBLED_ALPHABET.charAt((characterIndex + shiftKey) % UNSCRAMBLED_ALPHABET.length());
                if (Character.isUpperCase(character)) {
                    scrambledCharacter = Character.toUpperCase(scrambledCharacter);
                }
                stringBuilder.append(scrambledCharacter);
            } else {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

}

