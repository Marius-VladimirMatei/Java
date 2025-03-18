import java.util.Scanner;

// Class designed to handle user input
public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public int getValidatedInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
                System.out.print(prompt);
            }
        }
    }

    public int getStep() {
        String prompt = "Enter the step value: ";
        System.out.print(prompt);
        while (true) {
            String input = scanner.nextLine();
            try {
                int step = Integer.parseInt(input);
                if (step <= 0) {
                    System.out.println("Step value must be greater than zero.");
                    System.out.print(prompt);
                    continue;
                }
                return step;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
                System.out.print(prompt);
            }
        }
    }
}