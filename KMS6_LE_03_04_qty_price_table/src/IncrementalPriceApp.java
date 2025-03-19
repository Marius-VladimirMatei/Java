import java.util.List;

public class IncrementalPriceApp {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        System.out.println("Price Overview Table Generator!");

        int startPrice = inputHandler.getValidatedInt("Enter the starting price: ");
        int endPrice = inputHandler.getValidatedInt("Enter the ending price: ");

        // Ensure startPrice < endPrice
        if (startPrice > endPrice) {
            int temp = startPrice;
            startPrice = endPrice;
            endPrice = temp;
            System.out.println("Values swapped to ensure start price < end price.");
        }

        // Calculate step size
        int step = (endPrice - startPrice) / 10;
        if (step <= 0) step = 1; // Avoid step being zero

        System.out.println("Start Price: " + startPrice + ", End Price: " + endPrice + ", Step: " + step);

        // Generate list
        IncrementalPriceGenerator generator = new IncrementalPriceGenerator();
        List<Integer> priceList = generator.generateList(startPrice, endPrice, step);

        // Output the result in a structured format
        OutputHandler outputHandler = new OutputHandler();
        outputHandler.displayTable(priceList);
    }
}
