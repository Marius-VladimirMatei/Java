import java.util.Scanner;

public class Input {

    private Scanner scanner;

    // Constructor to initialize the scanner
    public Input() {
        scanner = new Scanner(System.in);
    }

    public int getValidatedInteger(String prompt) {
        System.out.println(prompt);
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. The year must be a whole number.");
                System.out.println(prompt);
            }
        }
    }
}
