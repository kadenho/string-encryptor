import java.util.Scanner;

public class StringEncryptor {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String plaintext = retrieveString("Enter plaintext string: ");
        String chosenEncryptionMethod = retrieveEncryptionMethod();
        switch (chosenEncryptionMethod) {
            case "Caesar Cipher":
                System.out.println("Caesar Cipher");
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
}