
import java.util.List;

// Class designed to generate a list of numbers based on start and end values provided ny the user
public class NumberListApp {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();

        System.out.println("Number List Generator!");

        int start = inputHandler.getStart();
        int end = inputHandler.getEnd();
        int step = inputHandler.getStep();

        System.out.println("Start: " + start + ", End: " + end + ", Step: " + step);

        // Create the number list generator to build the list
        NumberListGenerator generator = new NumberListGenerator();
        List<Integer> numberList = generator.generateList(start, end, step);

        // Output the result
        OutputHandler outputHandler = new OutputHandler();
        outputHandler.displayList(numberList);
    }
}