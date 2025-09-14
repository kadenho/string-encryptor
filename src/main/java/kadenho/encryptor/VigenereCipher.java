package kadenho.encryptor;

import static kadenho.encryptor.CipherUtils.encryptPolyAlphabetically;
import static kadenho.encryptor.CipherUtils.decryptPolyAlphabetically;

public class VigenereCipher {
    public static String[] encrypt(String plaintext, String keyString) {
        String lengthenedKeyString = constructVigenereLengthenedKeyString(plaintext, keyString);
        return new String[]{encryptPolyAlphabetically(plaintext, lengthenedKeyString), keyString};
    }

    public static String[] decrypt(String ciphertext, String keyString) {
        String lengthenedKeyString = constructVigenereLengthenedKeyString(ciphertext, keyString);
        return new String[]{decryptPolyAlphabetically(ciphertext, lengthenedKeyString), keyString};
    }

    private static String constructVigenereLengthenedKeyString(String plaintext, String keyString) {
        String filteredPlaintext = plaintext.replaceAll("[^a-zA-Z]", "");
        StringBuilder lengthenedKeyStringBuilder = new StringBuilder();
        int pointer = 0;
        while (lengthenedKeyStringBuilder.length() < filteredPlaintext.length()) {
            lengthenedKeyStringBuilder.append(keyString.charAt(pointer));
            pointer++;
            if (pointer == keyString.length()) {
                pointer = 0;
            }
        }
        return lengthenedKeyStringBuilder.toString();
    }
}
