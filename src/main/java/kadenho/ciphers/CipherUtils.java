package kadenho.ciphers;

public class CipherUtils {
    public static final String UNSCRAMBLED_ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static int getModularMultiplicativeInverse(int multiplicative) {
        Integer multiplicativeInverse = null;
        int multiplicativeInverseCandidate = 0;
        while (multiplicativeInverse == null) {
            if ((multiplicativeInverseCandidate * multiplicative) % UNSCRAMBLED_ALPHABET.length() == 1) {
                multiplicativeInverse = multiplicativeInverseCandidate;
            } else {
                multiplicativeInverseCandidate++;
            }
        }
        return multiplicativeInverse;
    }

    public static String convertAlphabets(String plaintext, String currentAlphabet, String newAlphabet) {
        StringBuilder ciphertextStringBuilder = new StringBuilder();
        for (char character : plaintext.toCharArray()) {
            int characterIndex = currentAlphabet.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                char scrambledCharacter = newAlphabet.charAt(characterIndex);
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

    public static String encryptPolyAlphabetically(String plaintext, String lengthenedKeyString) {
        int pointer = 0;
        StringBuilder ciphertextStringBuilder = new StringBuilder();
        for (char character : plaintext.toCharArray()) {
            int characterIndex = UNSCRAMBLED_ALPHABET.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                int indexShift = UNSCRAMBLED_ALPHABET.indexOf(Character.toLowerCase(lengthenedKeyString.charAt(pointer)));
                pointer++;
                char scrambledCharacter = UNSCRAMBLED_ALPHABET.charAt((characterIndex + indexShift) % UNSCRAMBLED_ALPHABET.length());
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

    public static String decryptPolyAlphabetically(String ciphertext, String lengthenedKeyString) {
        int pointer = 0;
        StringBuilder plaintextStringBuilder = new StringBuilder();
        for (char character : ciphertext.toCharArray()) {
            int characterIndex = UNSCRAMBLED_ALPHABET.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                int indexShift = UNSCRAMBLED_ALPHABET.indexOf(Character.toLowerCase(lengthenedKeyString.charAt(pointer)));
                int newIndex = characterIndex - indexShift;
                if (newIndex < 0) {
                    newIndex += UNSCRAMBLED_ALPHABET.length();
                }
                pointer++;
                char unscrambledCharacter = UNSCRAMBLED_ALPHABET.charAt(newIndex);
                if (Character.isUpperCase(character)) {
                    unscrambledCharacter = Character.toUpperCase(unscrambledCharacter);
                }
                plaintextStringBuilder.append(unscrambledCharacter);
            } else {
                plaintextStringBuilder.append(character);
            }
        }
        return plaintextStringBuilder.toString();
    }
}
