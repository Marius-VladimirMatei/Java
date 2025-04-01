import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    // Prompts the user, replaces commas with dots, and returns the entered input.
    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().replace(',', '.');
    }

    // Closes the scanner.
    public void close() {
        scanner.close();
    }
}
