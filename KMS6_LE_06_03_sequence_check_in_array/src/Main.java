import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the menu
            System.out.println("\nMenu:");
            System.out.println("1. Run the app");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                // Generate a random array of integers
                int[] randomArray = RandomArrayGenerator.generateRandomArray(20, 0, 9);
                OutputHandler.printArray("Random Array", randomArray);

                // Prompt the user for a sequence of integers
                int[] sequence = InputHandler.readSequence();
                if (sequence == null) {
                    OutputHandler.print("Invalid sequence input. Please try again.");
                    continue;
                }

                // Check if the sequence exists in the random array
                boolean found = SequenceChecker.searchSequence(randomArray, sequence);
                OutputHandler.printArray("Your Sequence", sequence);
                OutputHandler.print("Sequence found: " + (found ? "YES" : "NO"));
            } else if (choice.equals("2")) {
                System.out.println("Exiting program.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}























/*
public class Main {
    public static void main(String[] args) {
        // Generate a random array of integers
        int[] randomArray = RandomArrayGenerator.generateRandomArray(20, 0, 9);
        OutputHandler.printArray("Random Array", randomArray);

        // Prompt the user for a sequence of integers
        int[] sequence = InputHandler.readSequence();
        if (sequence == null) {
            OutputHandler.print("Exiting program.");
            return;
        }

        // Check if the sequence exists in the random array by calling the
        // searchSequence method
        boolean found = SequenceChecker.searchSequence(randomArray, sequence);
        OutputHandler.printArray("Your Sequence", sequence);
        OutputHandler.print("Sequence found: " + (found ? "YES" : "NO"));
    }
}
*/