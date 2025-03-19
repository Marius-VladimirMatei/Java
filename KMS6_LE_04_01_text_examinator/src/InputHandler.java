import java.util.Scanner;

// Class designed to handle the input from the user.

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        // Initialize the scanner to read from the console.
        scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        // Read the user input from the console.
        return scanner.nextLine();
    }

    public void close() {
        // Close the scanner to release resources
        scanner.close();
    }
}
