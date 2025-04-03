import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create the calculator, input, and output handlers.
        Calculator calculator = new Calculator();
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        // Scanner for the menu
        Scanner menuScanner = new Scanner(System.in);
        boolean continueApp = true;

        while (continueApp) {
            // Display the menu
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Calculator");
            System.out.println("2. Exit");
            System.out.print("Select an option (1 or 2): ");

            String option = menuScanner.nextLine();

            switch (option) {
                case "1":
                    // Perform the calculation.
                    double[] numbers = inputHandler.getNumbers();
                    double result = calculator.sum(numbers);
                    outputHandler.displayResult(numbers, result);
                    break;
                case "2":
                    // Exit the application.
                    continueApp = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please select 1 or 2.");
                    break;
            }
        }

        // Clean up resources - close the scanners
        inputHandler.close();
        menuScanner.close();
    }
}




/*
public class Main {

    public static void main(String[] args) {
        // Create an instance of the Calculator for summing the numbers.
        Calculator calculator = new Calculator();

        // Separate input and output handling.
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        // Get numbers from the user.
        double[] numbers = inputHandler.getNumbers();

        // Calculate the sum.
        double result = calculator.sum(numbers);

        // Display the results.
        outputHandler.displayResult(numbers, result);

        // Close the input scanner.
        inputHandler.close();
    }
}
*/