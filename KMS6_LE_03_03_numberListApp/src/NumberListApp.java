
import java.util.List;

// Class designed to generate a list of numbers based on start and end values provided ny the user
public class NumberListApp {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();

        System.out.println("Number List Generator!");

        int start = inputHandler.getValidatedInt("Enter the start value: ");
        int end = inputHandler.getValidatedInt("Enter the end value: ");
        int step = inputHandler.getStep();

        // Swap the values using a temporary variable
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
            System.out.println("Values swapped to ensure start < end.");
        }

        System.out.println("Start: " + start + ", End: " + end + ", Step: " + step);

        // Create the number list generator to build the list
        NumberListGenerator generator = new NumberListGenerator();
        List<Integer> numberList = generator.generateList(start, end, step);

        // Output the result
        OutputHandler outputHandler = new OutputHandler();
        outputHandler.displayList(numberList);
    }
}