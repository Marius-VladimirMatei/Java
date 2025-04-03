import java.util.Scanner;

// Class designed for the input

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public double[] getNumbers() {
        System.out.println("Enter numbers separated by spaces (then press Enter):");
        String inputLine = scanner.nextLine();

        // Split the input by spaces to extract individual number strings.
        String[] stringNumbers = inputLine.split("\\s+");

        // Convert each string to a double.
        double[] numbers = new double[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Double.parseDouble(stringNumbers[i]);
        }
        return numbers;
    }

    public void close() {
        scanner.close();
    }
}
