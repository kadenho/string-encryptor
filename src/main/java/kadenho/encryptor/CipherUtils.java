package kadenho.encryptor;

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
}
