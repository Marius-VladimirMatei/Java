import java.util.Scanner;

// Class designed to create the 2D matrix from the user input
public class InputHandler {

    // Declare the scanner as an instance field so it can be used in all methods
    private Scanner scanner;

    // Constructor initializes the scanner
    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public double[][] readMatrix() {
        // Read the number of rows.
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        // Read the number of columns.
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        double[][] matrix = new double[rows][cols];

        // Prompt the user to fill in the matrix values
        System.out.println("Enter the matrix values:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Value at row " + (i + 1) + ", column " + (j + 1) + ": ");
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    // Closes the scanner.
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
