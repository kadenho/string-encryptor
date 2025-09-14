package kadenho.ciphers;

import static kadenho.ciphers.CipherUtils.UNSCRAMBLED_ALPHABET;

public class AffineCipher {
    public static String[] encrypt(String plaintext, int multiplicativeKey, int additiveKey) {
        StringBuilder ciphertextStringBuilder = new StringBuilder();
        for (char character : plaintext.toCharArray()) {
            int characterIndex = UNSCRAMBLED_ALPHABET.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                char scrambledCharacter = UNSCRAMBLED_ALPHABET.charAt(((multiplicativeKey * characterIndex) + additiveKey) % UNSCRAMBLED_ALPHABET.length());
                if (Character.isUpperCase(character)) {
                    scrambledCharacter = Character.toUpperCase(scrambledCharacter);
                }
                ciphertextStringBuilder.append(scrambledCharacter);
            } else {
                ciphertextStringBuilder.append(character);
            }
        }
        String ciphertext = ciphertextStringBuilder.toString();
        return new String[]{ciphertext, Integer.toString(multiplicativeKey), Integer.toString(additiveKey)};
    }

    public static String[] decrypt(String ciphertext, int multiplicativeKey, int additiveKey) {
        int multiplicativeInverse = CipherUtils.getModularMultiplicativeInverse(multiplicativeKey);
        int alphabetLength = UNSCRAMBLED_ALPHABET.length();
        StringBuilder plaintextStringBuilder = new StringBuilder();
        for (char character : ciphertext.toCharArray()) {
            int characterIndex = UNSCRAMBLED_ALPHABET.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                int unscrambledCharacterIndex = ((characterIndex - additiveKey) * multiplicativeInverse) % alphabetLength;
                if (unscrambledCharacterIndex < 0) {
                    unscrambledCharacterIndex += alphabetLength;
                }
                char unscrambledCharacter = UNSCRAMBLED_ALPHABET.charAt(unscrambledCharacterIndex);
                if (Character.isUpperCase(character)) {
                    unscrambledCharacter = Character.toUpperCase(unscrambledCharacter);
                }
                plaintextStringBuilder.append(unscrambledCharacter);
            } else {
                plaintextStringBuilder.append(character);
            }
        }
        String plaintext = plaintextStringBuilder.toString();
        return new String[]{plaintext, Integer.toString(multiplicativeKey), Integer.toString(additiveKey)};
    }
}
