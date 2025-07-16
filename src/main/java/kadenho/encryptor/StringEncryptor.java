package kadenho.encryptor;

import java.util.Scanner;

public class StringEncryptor {
    public static final Scanner scanner = new Scanner(System.in);

    public static String retrieveString(String prompt, Boolean alphabetOnly) {
        System.out.print(prompt);
        String retrievedEntry =  scanner.nextLine();
        if (retrievedEntry.isEmpty()){
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

    public static String retrieveEncryptionMethod() {
        String[] availableEncryptionMethods = {"Caesar Cipher",
                "Mixed Alphabet Cipher", "Vigenere Cipher"};
        for (int i = 0; i < availableEncryptionMethods.length; i++) {
            System.out.println("[" + (i + 1) + "] " + availableEncryptionMethods[i]);
        }
        return availableEncryptionMethods[retrieveInteger("Enter encryption method: ", 1, availableEncryptionMethods.length) -1];
    }

    public static String convertAlphabets(String plaintext, String unscrambledAlphabet, String scrambledAlphabet) {
        StringBuilder cipherTextStringBuilder = new StringBuilder();
        for(char character : plaintext.toCharArray()) {
            int characterIndex = unscrambledAlphabet.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                char scrambledCharacter = scrambledAlphabet.charAt(characterIndex);
                if (Character.isUpperCase(character)){
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
        String unscrambledAlphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder cipherTextStringBuilder = new StringBuilder();
        for (char character : plaintext.toCharArray()) {
            int characterIndex = unscrambledAlphabet.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                char scrambledCharacter = unscrambledAlphabet.charAt((characterIndex + shiftKey) % 26);
                if (Character.isUpperCase(character)){
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

    public static String[] mixedAlphabetCipher(String plaintext, String keyString) {
        String unscrambledAlphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder scrambledAlphabetStringBuilder = new StringBuilder();
        for (char character : keyString.toCharArray()) {
            if (scrambledAlphabetStringBuilder.indexOf(String.valueOf(Character.toLowerCase(character))) == -1){
                scrambledAlphabetStringBuilder.append(Character.toLowerCase(character));
            }
        }
        for (char character : unscrambledAlphabet.toCharArray()) {
            if (scrambledAlphabetStringBuilder.indexOf(String.valueOf(Character.toLowerCase(character))) == -1){
                scrambledAlphabetStringBuilder.append(Character.toLowerCase(character));
            }
        }
        String scrambledAlphabet = scrambledAlphabetStringBuilder.toString();
        String cipherText = convertAlphabets(plaintext, unscrambledAlphabet, scrambledAlphabet);
        return new String[]{cipherText, keyString};
    }

    public static String[] vigenereCipher(String plainText, String keyString) {
        String filteredPlaintext = plainText.replaceAll("[^a-zA-Z]", "");
        StringBuilder lengthenedKeyStringBuilder = new StringBuilder();
        int pointer = 0;
        while (lengthenedKeyStringBuilder.length() < filteredPlaintext.length()){
            lengthenedKeyStringBuilder.append(keyString.charAt(pointer));
            pointer++;
            if (pointer == keyString.length()) {
                pointer = 0;
            }
        }
        String lengthenedKeyString = lengthenedKeyStringBuilder.toString();
        String unscrambledAlphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder cipherTextStringBuilder = new StringBuilder();
        pointer = 0;
        for (char character : plainText.toCharArray()) {
            int characterIndex = unscrambledAlphabet.indexOf(Character.toLowerCase(character));
            if (characterIndex >= 0) {
                int indexShift = unscrambledAlphabet.indexOf(Character.toLowerCase(lengthenedKeyString.charAt(pointer)));
                pointer++;
                char scrambledCharacter = unscrambledAlphabet.charAt((characterIndex + indexShift) % 26);
                if (Character.isUpperCase(character)){
                    scrambledCharacter = Character.toUpperCase(scrambledCharacter);
                }
                cipherTextStringBuilder.append(scrambledCharacter);
            } else {
                cipherTextStringBuilder.append(character);
            }
        }
        String cipherText = cipherTextStringBuilder.toString();
        return new String[]{cipherText, keyString};
    }

    public static void main(String[] args) {
        String plaintext = retrieveString("Enter plaintext string: ", false);
        String chosenEncryptionMethod = retrieveEncryptionMethod();
        switch (chosenEncryptionMethod) {
            case "Caesar Cipher":
                int shiftKey = retrieveInteger("Enter key (1-25): ", 1, 25);
                String[] caesarCipherOutput = caesarCipher(plaintext, shiftKey);
                System.out.println("\n{Caesar Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + caesarCipherOutput[0] +
                        "\nKey: " + caesarCipherOutput[1]);
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
            default:
                System.out.println("Error: Unable to find encryption method");
                System.exit(1);
        }
        scanner.close();
    }
}