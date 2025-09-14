package kadenho.ciphers;

import static kadenho.ciphers.CipherUtils.UNSCRAMBLED_ALPHABET;
import static kadenho.ciphers.CipherUtils.encryptPolyAlphabetically;

public class AutokeyCipher {
    public static String[] encrypt(String plaintext, String keyString) {
        String filteredPlaintext = plaintext.replaceAll("[^a-zA-Z]", "");
        StringBuilder lengthenedKeyStringBuilder = new StringBuilder(keyString);
        int pointer = 0;
        while (lengthenedKeyStringBuilder.length() < filteredPlaintext.length()) {
            lengthenedKeyStringBuilder.append(filteredPlaintext.charAt(pointer));
            pointer++;
        }
        String lengthenedKeyString = lengthenedKeyStringBuilder.toString();
        return new String[]{encryptPolyAlphabetically(plaintext, lengthenedKeyString), keyString};
    }

    public static String[] decrypt(String ciphertext, String keyString) {
        int pointer = 0;
        StringBuilder decryptionKey = new StringBuilder(keyString);
        StringBuilder plaintextStringbuilder = new StringBuilder();
        for (char character : ciphertext.toCharArray()) {
            int characterIndex = UNSCRAMBLED_ALPHABET.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                int indexShift = UNSCRAMBLED_ALPHABET.indexOf(Character.toLowerCase(decryptionKey.charAt(pointer)));
                int newIndex = characterIndex - indexShift;
                if (newIndex < 0) {
                    newIndex += UNSCRAMBLED_ALPHABET.length();
                }
                pointer++;
                char unscrambledCharacter = UNSCRAMBLED_ALPHABET.charAt(newIndex);
                decryptionKey.append(unscrambledCharacter);
                if (Character.isUpperCase(character)) {
                    unscrambledCharacter = Character.toUpperCase(unscrambledCharacter);
                }
                plaintextStringbuilder.append(unscrambledCharacter);
            } else {
                plaintextStringbuilder.append(character);
            }
        }
        return new String[]{plaintextStringbuilder.toString(), keyString};
    }
}
