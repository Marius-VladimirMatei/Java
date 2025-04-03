import java.util.Arrays;

// Class designed to output the result

public class OutputHandler {

    public void displayResult(double[] numbers, double sum) {
        System.out.println("You entered the following numbers: " + Arrays.toString(numbers));
        System.out.println("The sum of these numbers is: " + sum);
    }
}
