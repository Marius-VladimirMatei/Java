import java.util.Scanner;

public class InputValidator {
    private Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getValidatedDescription() {
        String prompt = ("Enter description (alphanumeric allowed, including special characters): ");
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (input.trim().isEmpty()) {
            System.out.println("Invalid input. Description cannot be empty.");
            System.out.print(prompt);
            input = scanner.nextLine();
        }
        return input;
    }

    public int getValidatedInteger() {
        String prompt = "Enter quantity (whole number only): ";
        System.out.print(prompt);
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                System.out.print(prompt);
            }
        }
    }

    public double getValidatedDouble() {
        String prompt = "Enter unit price (decimal, comma or point allowed): ";
        System.out.print(prompt);

        while (true) {
            String input = scanner.nextLine().replace(',', '.');
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a decimal number.");
                System.out.print(prompt);
            }
        }
    }
}
