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

    public static int retrieveInteger(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry, must enter an integer");
            return retrieveInteger(prompt);
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
        int pointer = shiftKey;
        StringBuilder scrambledAlphabetStringBuilder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            scrambledAlphabetStringBuilder.append(unscrambledAlphabet.charAt(pointer));
            pointer++;
            if (pointer == 26){
                pointer = 0;
            }
        }
        String scrambledAlphabet = scrambledAlphabetStringBuilder.toString();
        String cipherText = convertAlphabets(plaintext, unscrambledAlphabet, scrambledAlphabet);
        return new String[]{cipherText, Integer.toString(shiftKey)};
    }

    public static String[] mixedAlphabetCipher(String plaintext, String keyString) {
        String unscrambledAlphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder scrambledAlphabetStringBuilder = new StringBuilder();
        for (char character : keyString.toCharArray()) {
            if (scrambledAlphabetStringBuilder.indexOf(String.valueOf(character)) == -1){
                scrambledAlphabetStringBuilder.append(character);
            }
        }
        for (char character : unscrambledAlphabet.toCharArray()) {
            if (scrambledAlphabetStringBuilder.indexOf(String.valueOf(character)) == -1){
                scrambledAlphabetStringBuilder.append(character);
            }
        }
        String scrambledAlphabet = scrambledAlphabetStringBuilder.toString();
        String cipherText = convertAlphabets(plaintext, unscrambledAlphabet, scrambledAlphabet);
        return new String[]{cipherText, keyString};
    }

    public static void main(String[] args) {
        String plaintext = retrieveString("Enter plaintext string: ", false);
        String chosenEncryptionMethod = retrieveEncryptionMethod();
        switch (chosenEncryptionMethod) {
            case "Caesar Cipher":
                int shiftKey = retrieveInteger("Enter key (1-25): ", 1, 25);
                String[] caesarCipherOutcome = caesarCipher(plaintext, shiftKey);
                System.out.println("{Caesar Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + caesarCipherOutcome[0] +
                        "\nKey: " + caesarCipherOutcome[1]);
                break;
            case "Mixed Alphabet Cipher":
                String keyString = retrieveString("Enter key: ", true).toLowerCase();
                String[] mixedAlphabetCipherOutcome = mixedAlphabetCipher(plaintext, keyString);
                System.out.println("{Mixed Alphabet Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + mixedAlphabetCipherOutcome[0] +
                        "\nKey: " + mixedAlphabetCipherOutcome[1]);
                break;
            case "Vigenere Cipher":
                System.out.println("Vigenere Cipher");
                break;
            default:
                System.out.println("Error: Unable to find encryption method");
                System.exit(1);
        }
        scanner.close();
    }
}