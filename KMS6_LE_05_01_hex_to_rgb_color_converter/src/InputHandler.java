import java.util.Scanner;

// Handles prompting and reading user input.
public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    // Prompts and reads the menu choice.
    public String readMenuChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextLine();
    }

    // Prompts and reads a hex color code.
    public String readHexCode() {
        System.out.print("Enter a hex color code (e.g., #FF0000): ");
        return scanner.nextLine();
    }

    // Closes the scanner.
    public void close() {
        scanner.close();
    }
}
