import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the text to encrypt
        System.out.print("Enter the text to encrypt: ");
        String text = scanner.nextLine();

        // Prompt the user to enter the shift value
        System.out.print("Enter the shift value: ");
        int shift = scanner.nextInt();

        // Create a CaesarCipher instance with the given shift.
        CaesarCipher cipher = new CaesarCipher(shift);

        // Encrypt the text and display the result.
        String encryptedText = cipher.encrypt(text);
        System.out.println("Encrypted text: " + encryptedText);

        scanner.close();
    }
}
