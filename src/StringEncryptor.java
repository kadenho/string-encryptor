import java.util.Scanner;

public class StringEncryptor {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String plaintext = retrieveString("Enter plaintext string: ");
        String chosenEncryptionMethod = retrieveEncryptionMethod();
        switch (chosenEncryptionMethod) {
            case "Caesar Cipher":
                String[] caesarCipherOutcome = caesarCipher(plaintext);
                System.out.println("{Caesar Cipher}\nPlaintext: "
                        + plaintext + "\nCiphertext: " + caesarCipherOutcome[0] +
                        "\nKey: " + caesarCipherOutcome[1]);
                break;
            case "Vigenere Cipher":
                System.out.println("Vigenere Cipher");
                break;
            case "Mixed Alphabet Cipher":
                System.out.println("Mixed Alphabet Cipher");
                break;
            default:
                System.out.println("Error: Unable to find encryption method");
                System.exit(1);
        }
    }

    private static String retrieveString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int retrieveInteger(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry, must enter an integer");
            return retrieveInteger(prompt);
        }
    }

    private static int retrieveInteger(String prompt, int lowerBound, int upperBound) {
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

    private static String retrieveEncryptionMethod() {
        String[] availableEncryptionMethods = {"Caesar Cipher", "Vigenere Cipher",
                "Mixed Alphabet Cipher"};
        for (int i = 0; i < availableEncryptionMethods.length; i++) {
            System.out.println("[" + (i + 1) + "] " + availableEncryptionMethods[i]);
        }
        return availableEncryptionMethods[retrieveInteger("Enter encryption method: ", 1, availableEncryptionMethods.length) -1];
    }

    private static String[] caesarCipher(String plaintext) {
        String unscrambledAlphabet = "abcdefghijklmnopqrstuvwxyz";
        int shiftKey = retrieveInteger("Enter key (1-25): ", 1, 25);
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
        String cipherText = cipherTextStringBuilder.toString();
        return new String[]{cipherText, Integer.toString(shiftKey)};
    }
}