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

    public static String retrieveOperation() {
        String[] operations = {"Encrypt", "Decrypt"};
        StringBuilder operationPromptBuilder = new StringBuilder();
        for (int i = 0; i < operations.length; i++) {
            operationPromptBuilder.append("\n[").append(i + 1).append("] ").append(operations[i]);
        }
        operationPromptBuilder.append("\nEnter encryption method: ");
        String encryptionMethodPrompt = operationPromptBuilder.toString();
        return operations[retrieveInteger(encryptionMethodPrompt, 1, operations.length) - 1];
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

    private static String encryptPolyAlphabetically(String plaintext, String lengthenedKeyString) {
        int pointer = 0;
        StringBuilder ciphertextStringBuilder = new StringBuilder();
        for (char character : plaintext.toCharArray()) {
            int characterIndex = unscrambledAlphabet.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                int indexShift = unscrambledAlphabet.indexOf(Character.toLowerCase(lengthenedKeyString.charAt(pointer)));
                pointer++;
                char scrambledCharacter = unscrambledAlphabet.charAt((characterIndex + indexShift) % unscrambledAlphabet.length());
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

    private static String decryptPolyAlphabetically(String ciphertext, String lengthenedKeyString) {
        int pointer = 0;
        StringBuilder ciphertextStringBuilder = new StringBuilder();
        for (char character : ciphertext.toCharArray()) {
            int characterIndex = unscrambledAlphabet.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                int indexShift = unscrambledAlphabet.indexOf(Character.toLowerCase(lengthenedKeyString.charAt(pointer)));
                int newIndex = characterIndex - indexShift;
                if (newIndex < 0) {
                    newIndex += unscrambledAlphabet.length();
                }
                pointer++;
                char scrambledCharacter = unscrambledAlphabet.charAt(newIndex);
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


    public static String atbashTransform(String plaintext) {
        StringBuilder ciphertextStringBuilder = new StringBuilder();
        for (char character : plaintext.toCharArray()) {
            int characterIndex = unscrambledAlphabet.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                char scrambledCharacter = unscrambledAlphabet.charAt((unscrambledAlphabet.length() - 1) - characterIndex);
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


    public static String[] encryptCaesarCipher(String plaintext, int shiftKey) {
        StringBuilder ciphertextStringBuilder = new StringBuilder();
        for (char character : plaintext.toCharArray()) {
            int characterIndex = unscrambledAlphabet.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                char scrambledCharacter = unscrambledAlphabet.charAt((characterIndex + shiftKey) % unscrambledAlphabet.length());
                if (Character.isUpperCase(character)) {
                    scrambledCharacter = Character.toUpperCase(scrambledCharacter);
                }
                ciphertextStringBuilder.append(scrambledCharacter);
            } else {
                ciphertextStringBuilder.append(character);
            }
        }
        String ciphertext = ciphertextStringBuilder.toString();
        return new String[]{ciphertext, Integer.toString(shiftKey)};
    }

    public static String[] decryptCaesarCipher(String plaintext, int shiftKey) {
        StringBuilder ciphertextStringBuilder = new StringBuilder();
        int offsetShift = unscrambledAlphabet.length() - shiftKey;
        for (char character : plaintext.toCharArray()) {
            int characterIndex = unscrambledAlphabet.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                char scrambledCharacter = unscrambledAlphabet.charAt((characterIndex + offsetShift) % unscrambledAlphabet.length());
                if (Character.isUpperCase(character)) {
                    scrambledCharacter = Character.toUpperCase(scrambledCharacter);
                }
                ciphertextStringBuilder.append(scrambledCharacter);
            } else {
                ciphertextStringBuilder.append(character);
            }
        }
        String ciphertext = ciphertextStringBuilder.toString();
        return new String[]{ciphertext, Integer.toString(shiftKey)};
    }

    public static String[] encryptAffineCipher(String plaintext, int multiplicativeKey, int additiveKey) {
        StringBuilder ciphertextStringBuilder = new StringBuilder();
        for (char character : plaintext.toCharArray()) {
            int characterIndex = unscrambledAlphabet.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                char scrambledCharacter = unscrambledAlphabet.charAt(((multiplicativeKey * characterIndex) + additiveKey) % unscrambledAlphabet.length());
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


    public static String[] encryptMixedAlphabetCipher(String plaintext, String keyString) {
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
        String ciphertext = convertAlphabets(plaintext, unscrambledAlphabet, scrambledAlphabet);
        return new String[]{ciphertext, keyString};
    }

    public static String[] decryptMixedAlphabetCipher(String plaintext, String keyString) {
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
        String ciphertext = convertAlphabets(plaintext, scrambledAlphabet, unscrambledAlphabet);
        return new String[]{ciphertext, keyString};
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

    public static String[] encryptVigenereCipher(String plaintext, String keyString) {
        String lengthenedKeyString = constructVigenereLengthenedKeyString(plaintext, keyString);
        return new String[] {encryptPolyAlphabetically(plaintext, lengthenedKeyString), keyString};
    }

    public static String[] decryptVigenereCipher(String ciphertext, String keyString) {
        String lengthenedKeyString = constructVigenereLengthenedKeyString(ciphertext, keyString);
        return new String[] {decryptPolyAlphabetically(ciphertext, lengthenedKeyString), keyString};
    }

    public static String[] encryptAutokeyCipher(String plaintext, String keyString) {
        String filteredPlaintext = plaintext.replaceAll("[^a-zA-Z]", "");
        StringBuilder lengthenedKeyStringBuilder = new StringBuilder(keyString);
        int pointer = 0;
        while (lengthenedKeyStringBuilder.length() < filteredPlaintext.length()) {
            lengthenedKeyStringBuilder.append(filteredPlaintext.charAt(pointer));
            pointer++;
        }
        String lengthenedKeyString = lengthenedKeyStringBuilder.toString();
        return new String[] {encryptPolyAlphabetically(plaintext, lengthenedKeyString), keyString};
    }

    private static void encryptString() {
        String plaintext = retrieveString("\nEnter plaintext string: ", false);
        String chosenEncryptionMethod = retrieveEncryptionMethod();
        switch (chosenEncryptionMethod) {
            case "Atbash Transform":
                String atbashTransformOutput = atbashTransform(plaintext);
                System.out.println("\n{Atbash Transform}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + atbashTransformOutput);
                break;
            case "Caesar Cipher":
                int caesarShiftKey = retrieveInteger("Enter key (1-25): ", 1, 25);
                String[] caesarCipherOutput = encryptCaesarCipher(plaintext, caesarShiftKey);
                System.out.println("\n{Caesar Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + caesarCipherOutput[0] +
                        "\nKey: " + caesarCipherOutput[1]);
                break;
            case "Affine Cipher":
                int[] coprimesOfTwentySix = {1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25};
                int multiplicativeKey = retrieveFromIntegerList("Enter multiplicative key: ", coprimesOfTwentySix);
                int additiveKey = retrieveInteger("Enter additive key: ", 0, Integer.MAX_VALUE);
                String[] affineCipherOutput = encryptAffineCipher(plaintext, multiplicativeKey, additiveKey);
                System.out.println("\n{Affine Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + affineCipherOutput[0] +
                        "\nMultiplicative key: " + affineCipherOutput[1] +
                        "\nAdditive key: " + affineCipherOutput[2]);
                break;
            case "Mixed Alphabet Cipher":
                String mixedAlphabetKeyString = retrieveString("Enter key: ", true);
                String[] mixedAlphabetCipherOutput = encryptMixedAlphabetCipher(plaintext, mixedAlphabetKeyString);
                System.out.println("\n{Mixed Alphabet Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + mixedAlphabetCipherOutput[0] +
                        "\nKey: " + mixedAlphabetCipherOutput[1]);
                break;
            case "Vigenere Cipher":
                String vigenereCipherKeyString = retrieveString("Enter key: ", true);
                String[] vigenereCipherOutput = encryptVigenereCipher(plaintext, vigenereCipherKeyString);
                System.out.println("\n{Vigenere Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + vigenereCipherOutput[0] +
                        "\nKey: " + vigenereCipherOutput[1]);
                break;
            case "Autokey Cipher":
                String autokeyCipherKeyString = retrieveString("Enter primer: ", true);
                String[] autokeyCipherOutput = encryptAutokeyCipher(plaintext, autokeyCipherKeyString);
                System.out.println("\n{Vigenere Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + autokeyCipherOutput[0] +
                        "\nPrimer: " + autokeyCipherOutput[1]);
                break;
            default:
                System.out.println("Error: Unable to find encryption method");
                System.exit(1);
        }
    }

    private static void decryptString() {
        String ciphertext = retrieveString("\nEnter ciphertext string: ", false);
        String chosenEncryptionMethod = retrieveEncryptionMethod();
        switch (chosenEncryptionMethod) {
            case "Atbash Transform":
                String atbashTransformOutput = atbashTransform(ciphertext);
                System.out.println("\n{Atbash Transform}\nPlaintext: "
                        + ciphertext + "\nCiphertext: " + atbashTransformOutput);
                break;
            case "Caesar Cipher":
                int caesarShiftKey = retrieveInteger("Enter key (1-25): ", 1, 25);
                String[] caesarCipherOutput = decryptCaesarCipher(ciphertext, caesarShiftKey);
                System.out.println("\n{Caesar Cipher}\nCiphertext: "
                        + ciphertext + "\nPlaintext: " + caesarCipherOutput[0] +
                        "\nKey: " + caesarCipherOutput[1]);
                break;
            case "Affine Cipher":
                System.out.print("{Affine Cipher");
                break;
            case "Mixed Alphabet Cipher":
                String mixedAlphabetKeyString = retrieveString("Enter key: ", true);
                String[] mixedAlphabetCipherOutput = decryptMixedAlphabetCipher(ciphertext, mixedAlphabetKeyString);
                System.out.println("\n{Mixed Alphabet Cipher}\nCiphertext: "
                        + ciphertext + "\nPlaintext: " + mixedAlphabetCipherOutput[0] +
                        "\nKey: " + mixedAlphabetCipherOutput[1]);
                break;
            case "Vigenere Cipher":
                String vigenereCipherKeyString = retrieveString("Enter key: ", true);
                String[] vigenereCipherOutput = decryptVigenereCipher(ciphertext, vigenereCipherKeyString);
                System.out.println("\n{Vigenere Cipher}\nCiphertext: "
                        + ciphertext + "\nPlaintext: " + vigenereCipherOutput[0] +
                        "\nKey: " + vigenereCipherOutput[1]);
                break;
            case "Autokey Cipher":
                System.out.print("{Autokey Cipher");
                break;
            default:
                System.out.println("Error: Unable to find encryption method");
                System.exit(1);
        }
    }

    public static void main(String[] args) {
        String operation = retrieveOperation();
        if (operation.equals("Encrypt")) {
            encryptString();
        } else if (operation.equals("Decrypt")) {
            decryptString();
        }

        scanner.close();
    }
}