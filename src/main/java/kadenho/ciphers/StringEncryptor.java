package kadenho.ciphers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static kadenho.ciphers.CipherUtils.UNSCRAMBLED_ALPHABET;

public class StringEncryptor {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String[] AVAILABLE_ENCRYPTION_METHODS = {"Atbash Transform", "Caesar Cipher",
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
        if (Arrays.stream(integerOptions).anyMatch(num -> num == retrievedEntry)) {
            return retrievedEntry;
        } else {
            System.out.println("Invalid entry, not an available option");
            return retrieveFromIntegerList(prompt, integerOptions);
        }
    }

    public static String retrieveOperation() {
        String[] operations = {"Encrypt", "Decrypt"};
        String operationPrompt = buildOptionsPromptList(operations, "Enter operation: ");
        return operations[retrieveInteger(operationPrompt, 1, operations.length) - 1];
    }

    public static String retrieveEncryptionMethod() {
        String encryptionMethodPrompt = buildOptionsPromptList(AVAILABLE_ENCRYPTION_METHODS, "Enter encryption method: ");
        return AVAILABLE_ENCRYPTION_METHODS[retrieveInteger(encryptionMethodPrompt, 1, AVAILABLE_ENCRYPTION_METHODS.length) - 1];
    }

    public static String retrieveRunAgainDecision() {
        String[] options = {"Run again", "Exit"};
        String encryptionMethodPrompt = buildOptionsPromptList(options, "Run again: ");
        return options[retrieveInteger(encryptionMethodPrompt, 1, options.length) - 1];
    }

    private static String buildOptionsPromptList(String[] options, String enterPrompt) {
        StringBuilder optionPromptBuilder = new StringBuilder();
        for (int i = 0; i < options.length; i++) {
            optionPromptBuilder.append("\n[").append(i + 1).append("] ").append(options[i]);
        }
        optionPromptBuilder.append("\n").append(enterPrompt);
        return optionPromptBuilder.toString();

    }

    private static int[] getCoprimes(int modulus) {
        ArrayList<Integer> coprimes = new ArrayList<>();
        for (int i = 1; i < modulus; i++) { // Candidates for coprimes
            int greatestCommonDenominator = 0;
            for (int j = 1; j <= i; j++) { // Candidates for GCD
                if ((i % j == 0) && (modulus % j == 0)) {
                    greatestCommonDenominator = j;
                }
            }
            if (greatestCommonDenominator == 1) {
                coprimes.add(i);
            }
        }
        return coprimes.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void encryptString() {
        String plaintext = retrieveString("\nEnter plaintext string: ", false);
        String chosenEncryptionMethod = retrieveEncryptionMethod();
        switch (chosenEncryptionMethod) {
            case "Atbash Transform":
                String atbashTransformOutput = AtbashTransform.encrypt(plaintext);
                System.out.println("\n{Atbash Transform}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + atbashTransformOutput);
                break;
            case "Caesar Cipher":
                int caesarShiftKey = retrieveInteger("Enter key (1-25): ", 1, 25);
                String[] caesarCipherOutput = CaesarCipher.encrypt(plaintext, caesarShiftKey);
                System.out.println("\n{Caesar Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + caesarCipherOutput[0] +
                        "\nKey: " + caesarCipherOutput[1]);
                break;
            case "Affine Cipher":
                int[] coprimes = getCoprimes(UNSCRAMBLED_ALPHABET.length());
                int multiplicativeKey = retrieveFromIntegerList("Enter multiplicative key: ", coprimes);
                int additiveKey = retrieveInteger("Enter additive key: ", 0, Integer.MAX_VALUE);
                String[] affineCipherOutput = AffineCipher.encrypt(plaintext, multiplicativeKey, additiveKey);
                System.out.println("\n{Affine Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + affineCipherOutput[0] +
                        "\nMultiplicative key: " + affineCipherOutput[1] +
                        "\nAdditive key: " + affineCipherOutput[2]);
                break;
            case "Mixed Alphabet Cipher":
                String mixedAlphabetKeyString = retrieveString("Enter key: ", true);
                String[] mixedAlphabetCipherOutput = MixedAlphabetCipher.encrypt(plaintext, mixedAlphabetKeyString);
                System.out.println("\n{Mixed Alphabet Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + mixedAlphabetCipherOutput[0] +
                        "\nKey: " + mixedAlphabetCipherOutput[1]);
                break;
            case "Vigenere Cipher":
                String vigenereCipherKeyString = retrieveString("Enter key: ", true);
                String[] vigenereCipherOutput = VigenereCipher.encrypt(plaintext, vigenereCipherKeyString);
                System.out.println("\n{Vigenere Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + vigenereCipherOutput[0] +
                        "\nKey: " + vigenereCipherOutput[1]);
                break;
            case "Autokey Cipher":
                String autokeyCipherKeyString = retrieveString("Enter primer: ", true);
                String[] autokeyCipherOutput = AutokeyCipher.encrypt(plaintext, autokeyCipherKeyString);
                System.out.println("\n{Autokey Cipher}\nPlaintext: "
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
                String atbashTransformOutput = AtbashTransform.decrypt(ciphertext);
                System.out.println("\n{Atbash Transform}\nPlaintext: "
                        + ciphertext + "\nCiphertext: " + atbashTransformOutput);
                break;
            case "Caesar Cipher":
                int caesarShiftKey = retrieveInteger("Enter key (1-25): ", 1, 25);
                String[] caesarCipherOutput = CaesarCipher.decrypt(ciphertext, caesarShiftKey);
                System.out.println("\n{Caesar Cipher}\nCiphertext: "
                        + ciphertext + "\nPlaintext: " + caesarCipherOutput[0] +
                        "\nKey: " + caesarCipherOutput[1]);
                break;
            case "Affine Cipher":
                int[] coprimes = getCoprimes(UNSCRAMBLED_ALPHABET.length());
                int multiplicativeKey = retrieveFromIntegerList("Enter multiplicative key: ", coprimes);
                int additiveKey = retrieveInteger("Enter additive key: ", 0, Integer.MAX_VALUE);
                String[] affineCipherOutput = AffineCipher.decrypt(ciphertext, multiplicativeKey, additiveKey);
                System.out.println("\n{Affine Cipher}\nCiphertext: "
                        + ciphertext + "\nPlaintext: " + affineCipherOutput[0] +
                        "\nMultiplicative key: " + affineCipherOutput[1] +
                        "\nAdditive key: " + affineCipherOutput[2]);
                break;
            case "Mixed Alphabet Cipher":
                String mixedAlphabetKeyString = retrieveString("Enter key: ", true);
                String[] mixedAlphabetCipherOutput = MixedAlphabetCipher.decrypt(ciphertext, mixedAlphabetKeyString);
                System.out.println("\n{Mixed Alphabet Cipher}\nCiphertext: "
                        + ciphertext + "\nPlaintext: " + mixedAlphabetCipherOutput[0] +
                        "\nKey: " + mixedAlphabetCipherOutput[1]);
                break;
            case "Vigenere Cipher":
                String vigenereCipherKeyString = retrieveString("Enter key: ", true);
                String[] vigenereCipherOutput = VigenereCipher.decrypt(ciphertext, vigenereCipherKeyString);
                System.out.println("\n{Vigenere Cipher}\nCiphertext: "
                        + ciphertext + "\nPlaintext: " + vigenereCipherOutput[0] +
                        "\nKey: " + vigenereCipherOutput[1]);
                break;
            case "Autokey Cipher":
                String autokeyCipherKeyString = retrieveString("Enter primer: ", true);
                String[] autokeyCipherOutput = AutokeyCipher.decrypt(ciphertext, autokeyCipherKeyString);
                System.out.println("\n{Autokey Cipher}\nCiphertext: "
                        + ciphertext + "\nPlaintext: " + autokeyCipherOutput[0] +
                        "\nPrimer: " + autokeyCipherOutput[1]);
                break;
            default:
                System.out.println("Error: Unable to find encryption method");
                System.exit(1);
        }
    }

    public static void main(String[] args) {
        System.out.println("{String Encryptor}");
        String operation = retrieveOperation();
        if (operation.equals("Encrypt")) {
            encryptString();
        } else if (operation.equals("Decrypt")) {
            decryptString();
        } else {
            System.out.println("Error: Unable to retrieve operation");
            System.exit(2);
        }
        String runAgainDecision = retrieveRunAgainDecision();
        if (runAgainDecision.equals("Run again")) {
            System.out.println();
            main(args);
        } else if (runAgainDecision.equals("Exit")) {
            scanner.close();
            System.exit(0);
        } else {
            System.out.println("Error: Unable to retrieve decision");
            System.exit(3);
        }
    }
}