package kadenho.encryptor;

import java.util.Arrays;
import java.util.Scanner;

public class StringEncryptor {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String unscrambledAlphabet = "abcdefghijklmnopqrstuvwxyz";
    public static final String[] availableEncryptionMethods = {"Atbash Transform", "Caesar Cipher",
            "Affine Cipher", "Mixed Alphabet Cipher", "Vigenere Cipher", "Autokey Cipher"};

    public static String retrieveString(String prompt, Boolean alphabetOnly) {
        System.out.print(prompt);
        String retrievedEntry = scanner.nextLine();
        if (retrievedEntry.isEmpty()) {
            System.out.println("Invalid entry, cannot be empty");
            return retrieveString(prompt, alphabetOnly);
        } else {
            if (!alphabetOnly || retrievedEntry.matches(("[a-zA-Z]+"))) {
                return retrievedEntry;
            } else {
                System.out.println("Invalid entry, must only contain letters A-Z");
                return retrieveString(prompt, alphabetOnly);
            }
        }
    }

    public static int retrieveInteger(String prompt, int lowerBound, int upperBound) {
        System.out.print(prompt);
        int retrievedEntry;
        try {
            retrievedEntry = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry, must enter an integer");
            return retrieveInteger(prompt, lowerBound, upperBound);
        }
        if (retrievedEntry < lowerBound) {
            System.out.println("Invalid entry, must be no less than " + lowerBound);
            return retrieveInteger(prompt, lowerBound, upperBound);
        } else if (retrievedEntry > upperBound) {
            System.out.println("Invalid entry, must be no more than " + upperBound);
            return retrieveInteger(prompt, lowerBound, upperBound);
        } else {
            return retrievedEntry;
        }
    }

    public static int retrieveFromIntegerList(String prompt, int[] integerOptions) {
        System.out.println("Options: " + Arrays.toString(integerOptions));
        System.out.print(prompt);
        int retrievedEntry;
        try {
            retrievedEntry = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry, must enter an integer");
            return retrieveFromIntegerList(prompt, integerOptions);
        }
        if  (Arrays.stream(integerOptions).anyMatch(num -> num == retrievedEntry)) {
            return retrievedEntry;
        } else {
            System.out.println("Invalid entry, not an available option");
            return retrieveFromIntegerList(prompt, integerOptions);
        }

    }

    public static String retrieveEncryptionMethod() {
        StringBuilder encryptionMethodPromptBuilder = new StringBuilder();
        for (int i = 0; i < availableEncryptionMethods.length; i++) {
            encryptionMethodPromptBuilder.append("\n[").append(i + 1).append("] ").append(availableEncryptionMethods[i]);
        }
        encryptionMethodPromptBuilder.append("\nEnter encryption method: ");
        String encryptionMethodPrompt = encryptionMethodPromptBuilder.toString();
        return availableEncryptionMethods[retrieveInteger(encryptionMethodPrompt, 1, availableEncryptionMethods.length) - 1];
    }

    public static String encryptMonoAlphabetically(String plaintext, String unscrambledAlphabet, String scrambledAlphabet) {
        StringBuilder cipherTextStringBuilder = new StringBuilder();
        for (char character : plaintext.toCharArray()) {
            int characterIndex = unscrambledAlphabet.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                char scrambledCharacter = scrambledAlphabet.charAt(characterIndex);
                if (Character.isUpperCase(character)) {
                    scrambledCharacter = Character.toUpperCase(scrambledCharacter);
                }
                cipherTextStringBuilder.append(scrambledCharacter);
            } else {
                cipherTextStringBuilder.append(character);
            }
        }
        return cipherTextStringBuilder.toString();
    }

    private static String encryptPolyAlphabetically(String plainText, String lengthenedKeyString) {
        int pointer;
        StringBuilder cipherTextStringBuilder = new StringBuilder();
        pointer = 0;
        for (char character : plainText.toCharArray()) {
            int characterIndex = unscrambledAlphabet.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                int indexShift = unscrambledAlphabet.indexOf(Character.toLowerCase(lengthenedKeyString.charAt(pointer)));
                pointer++;
                char scrambledCharacter = unscrambledAlphabet.charAt((characterIndex + indexShift) % unscrambledAlphabet.length());
                if (Character.isUpperCase(character)) {
                    scrambledCharacter = Character.toUpperCase(scrambledCharacter);
                }
                cipherTextStringBuilder.append(scrambledCharacter);
            } else {
                cipherTextStringBuilder.append(character);
            }
        }
        return cipherTextStringBuilder.toString();
    }


    public static String atbashTransform(String plaintext) {
        StringBuilder cipherTextStringBuilder = new StringBuilder();
        for (char character : plaintext.toCharArray()) {
            int characterIndex = unscrambledAlphabet.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                char scrambledCharacter = unscrambledAlphabet.charAt((unscrambledAlphabet.length() - 1) - characterIndex);
                if (Character.isUpperCase(character)) {
                    scrambledCharacter = Character.toUpperCase(scrambledCharacter);
                }
                cipherTextStringBuilder.append(scrambledCharacter);
            } else {
                cipherTextStringBuilder.append(character);
            }
        }
        return cipherTextStringBuilder.toString();
    }


    public static String[] caesarCipher(String plaintext, int shiftKey) {
        StringBuilder cipherTextStringBuilder = new StringBuilder();
        for (char character : plaintext.toCharArray()) {
            int characterIndex = unscrambledAlphabet.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                char scrambledCharacter = unscrambledAlphabet.charAt((characterIndex + shiftKey) % unscrambledAlphabet.length());
                if (Character.isUpperCase(character)) {
                    scrambledCharacter = Character.toUpperCase(scrambledCharacter);
                }
                cipherTextStringBuilder.append(scrambledCharacter);
            } else {
                cipherTextStringBuilder.append(character);
            }
        }
        String cipherText = cipherTextStringBuilder.toString();
        return new String[]{cipherText, Integer.toString(shiftKey)};
    }


    public static String[] affineCipher(String plaintext, int multiplicativeKey, int additiveKey) {
        StringBuilder cipherTextStringBuilder = new StringBuilder();
        for (char character : plaintext.toCharArray()) {
            int characterIndex = unscrambledAlphabet.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                char scrambledCharacter = unscrambledAlphabet.charAt(((multiplicativeKey * characterIndex) + additiveKey) % unscrambledAlphabet.length());
                if (Character.isUpperCase(character)) {
                    scrambledCharacter = Character.toUpperCase(scrambledCharacter);
                }
                cipherTextStringBuilder.append(scrambledCharacter);
            } else {
                cipherTextStringBuilder.append(character);
            }
        }
        String cipherText = cipherTextStringBuilder.toString();
        return new String[]{cipherText, Integer.toString(multiplicativeKey), Integer.toString(additiveKey)};
    }


    public static String[] mixedAlphabetCipher(String plaintext, String keyString) {
        StringBuilder scrambledAlphabetStringBuilder = new StringBuilder();
        for (char character : keyString.toCharArray()) {
            if (scrambledAlphabetStringBuilder.indexOf(String.valueOf(Character.toLowerCase(character))) == -1) {
                scrambledAlphabetStringBuilder.append(Character.toLowerCase(character));
            }
        }
        for (char character : unscrambledAlphabet.toCharArray()) {
            if (scrambledAlphabetStringBuilder.indexOf(String.valueOf(Character.toLowerCase(character))) == -1) {
                scrambledAlphabetStringBuilder.append(Character.toLowerCase(character));
            }
        }
        String scrambledAlphabet = scrambledAlphabetStringBuilder.toString();
        String cipherText = encryptMonoAlphabetically(plaintext, unscrambledAlphabet, scrambledAlphabet);
        return new String[]{cipherText, keyString};
    }

    public static String[] vigenereCipher(String plainText, String keyString) {
        String filteredPlaintext = plainText.replaceAll("[^a-zA-Z]", "");
        StringBuilder lengthenedKeyStringBuilder = new StringBuilder();
        int pointer = 0;
        while (lengthenedKeyStringBuilder.length() < filteredPlaintext.length()) {
            lengthenedKeyStringBuilder.append(keyString.charAt(pointer));
            pointer++;
            if (pointer == keyString.length()) {
                pointer = 0;
            }
        }
        String lengthenedKeyString = lengthenedKeyStringBuilder.toString();
        return new String[] {encryptPolyAlphabetically(plainText, lengthenedKeyString), keyString};
    }

    public static String[] autokeyCipher(String plainText, String keyString) {
        String filteredPlaintext = plainText.replaceAll("[^a-zA-Z]", "");
        StringBuilder lengthenedKeyStringBuilder = new StringBuilder(keyString);
        int pointer = 0;
        while (lengthenedKeyStringBuilder.length() < filteredPlaintext.length()) {
            lengthenedKeyStringBuilder.append(filteredPlaintext.charAt(pointer));
            pointer++;
        }
        String lengthenedKeyString = lengthenedKeyStringBuilder.toString();
        return new String[] {encryptPolyAlphabetically(plainText, lengthenedKeyString), keyString};
    }

    public static void main(String[] args) {
        String plaintext = retrieveString("Enter plaintext string: ", false);
        String chosenEncryptionMethod = retrieveEncryptionMethod();
        switch (chosenEncryptionMethod) {
            case "Atbash Transform":
                String atbashTransformOutput = atbashTransform(plaintext);
                System.out.println("\n{Atbash Transform}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + atbashTransformOutput);
                break;
            case "Caesar Cipher":
                int caesarShiftKey = retrieveInteger("Enter key (1-25): ", 1, 25);
                String[] caesarCipherOutput = caesarCipher(plaintext, caesarShiftKey);
                System.out.println("\n{Caesar Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + caesarCipherOutput[0] +
                        "\nKey: " + caesarCipherOutput[1]);
                break;
            case "Affine Cipher":
                int[] coprimesOfTwentySix = {1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25};
                int multiplicativeKey = retrieveFromIntegerList("Enter multiplicative key: ", coprimesOfTwentySix);
                int additiveKey = retrieveInteger("Enter additive key: ", 0, Integer.MAX_VALUE);
                String[] affineCipherOutput = affineCipher(plaintext, multiplicativeKey, additiveKey);
                System.out.println("\n{Caesar Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + affineCipherOutput[0] +
                        "\nMultiplicative key: " + affineCipherOutput[1] +
                        "\nAdditive key: " + affineCipherOutput[2]);
                break;
            case "Mixed Alphabet Cipher":
                String mixedAlphabetKeyString = retrieveString("Enter key: ", true);
                String[] mixedAlphabetCipherOutput = mixedAlphabetCipher(plaintext, mixedAlphabetKeyString);
                System.out.println("\n{Mixed Alphabet Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + mixedAlphabetCipherOutput[0] +
                        "\nKey: " + mixedAlphabetCipherOutput[1]);
                break;
            case "Vigenere Cipher":
                String vigenereCipherKeyString = retrieveString("Enter key: ", true);
                String[] vigenereCipherOutput = vigenereCipher(plaintext, vigenereCipherKeyString);
                System.out.println("\n{Vigenere Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + vigenereCipherOutput[0] +
                        "\nKey: " + vigenereCipherOutput[1]);
                break;
            case "Autokey Cipher":
                String autokeyCipherKeyString = retrieveString("Enter primer: ", true);
                String[] autokeyCipherOutput = autokeyCipher(plaintext, autokeyCipherKeyString);
                System.out.println("\n{Vigenere Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + autokeyCipherOutput[0] +
                        "\nPrimer: " + autokeyCipherOutput[1]);
                break;
            default:
                System.out.println("Error: Unable to find encryption method");
                System.exit(1);
        }

        scanner.close();
    }
}