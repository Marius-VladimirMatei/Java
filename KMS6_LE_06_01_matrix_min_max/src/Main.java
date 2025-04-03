
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner menuScanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        MatrixCalculator calculator = new MatrixCalculator();

        boolean exit = false;
        while (!exit) {
            // Display the console menu
            System.out.println("====== MATRIX CALCULATOR MENU ======");
            System.out.println("1. Enter new matrix data");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            String choice = menuScanner.nextLine();

            // Use switch-case to handle the menu selection
            switch (choice) {
                case "1":
                    // Read the matrix (all prompts handled inside InputHandler)
                    double[][] matrix = inputHandler.readMatrix();
                    // If the user cancelled the input (e.g., by typing "exit"), skip processing
                    if (matrix == null) {
                        System.out.println("Matrix input cancelled. Returning to the menu.\n");
                        break;
                    }
                    // Display the matrix
                    outputHandler.printMatrix(matrix);
                    // Calculate and display the statistics
                    double min = calculator.findMin(matrix);
                    double max = calculator.findMax(matrix);
                    outputHandler.printStatistics(min, max);
                    System.out.println("-----------------------------------\n");
                    break;
                case "2":
                    System.out.println("Exiting the program...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        }
        menuScanner.close();
    }
}



















/*
public class Main {

    public static void main(String[] args) {
        // Create an instance of the input handler and read the matrix
        InputHandler inputHandler = new InputHandler();
        double[][] matrix = inputHandler.readMatrix();

        // Create an instance of the output handler and print the matrix
        OutputHandler outputHandler = new OutputHandler();
        outputHandler.printMatrix(matrix);

        // Create an instance of the MatrixCalculator to compute min and max values
        MatrixCalculator calculator = new MatrixCalculator();
        double min = calculator.findMin(matrix);
        double max = calculator.findMax(matrix);

        // Display of the min and max values to the output handler
        outputHandler.printStatistics(min, max);
    }
}
*/