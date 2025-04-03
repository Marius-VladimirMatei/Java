import java.util.Scanner;

public class InputHandler {
    public static int[] readSequence() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter integers separated by spaces: ");
        String line = scanner.nextLine();

        // Logic to convert the input string to an array of integers needed as input for
        // the sequence checker
        String[] parts = line.split(" ");
        int[] numbers = new int[parts.length]; // create an array of integers with the same size as the number of parts
        for (int i = 0; i < parts.length; i++) {
            try {
                numbers[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + parts[i]);
                scanner.close();
                return null;
            }
        }
        scanner.close();
        return numbers;
    }
}