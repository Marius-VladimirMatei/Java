import java.util.Scanner;

// Handles prompting and reading user input.
public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        // Initialize the scanner to read from the console.
        scanner = new Scanner(System.in);
    }

    // Prompts the user and reads a hex color code.
    public String readHexCode() {
        System.out.print("Enter a hex color code (e.g., #FF0000): ");
        return scanner.nextLine();
    }

    // Closes the scanner.
    public void close() {
        scanner.close();
    }
}
