package kadenho.encryptor;

import static kadenho.encryptor.CipherUtils.UNSCRAMBLED_ALPHABET;

public class AtbashTransform {

    public static String encrypt(String plaintext) {
        StringBuilder ciphertextStringBuilder = new StringBuilder();
        for (char character : plaintext.toCharArray()) {
            int characterIndex = UNSCRAMBLED_ALPHABET.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                char scrambledCharacter = UNSCRAMBLED_ALPHABET.charAt((UNSCRAMBLED_ALPHABET.length() - 1) - characterIndex);
                if (Character.isUpperCase(character)) {
                    scrambledCharacter = Character.toUpperCase(scrambledCharacter);
                }
                ciphertextStringBuilder.append(scrambledCharacter);
            } else {
                ciphertextStringBuilder.append(character);
            }
        }
        return ciphertextStringBuilder.toString();
    }

    public static String decrypt(String plaintext) {
        return encrypt(plaintext);
    }
}
