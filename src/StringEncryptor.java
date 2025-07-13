import java.util.Scanner;

public class StringEncryptor {
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
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static String retrieveEncryptionMethod() {
        Scanner scanner = new Scanner(System.in);
        String[] availableEncryptionMethods = {"Caesar Cipher", "Vigenere Cipher",
                "Mixed Alphabet Cipher"};
        for (int i = 0; i < availableEncryptionMethods.length; i++) {
            System.out.println("[" + (i + 1) + "] " + availableEncryptionMethods[i]);
        }
        System.out.print("Enter encryption method: ");
        int retrievedAnswer;
        try {
            retrievedAnswer = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry, must enter an integer");
            return retrieveEncryptionMethod();
        } try {
            return availableEncryptionMethods[retrievedAnswer - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid entry, must be between 1 and " + availableEncryptionMethods.length);
            return retrieveEncryptionMethod();
        }
    }


}