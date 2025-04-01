// Class design to parse article information from input and print details in the format
// "articleName, articleDescription, orderNumber, value, orderedBy"

public class ArticleService {

    public Article parseArticleFromInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("No input provided.");
            return null;
        }

        // Split the input string by commas and trim each part.
        // Check if the input has the correct number of parts.
        String[] parts = input.split(",");
        if (parts.length < 5) {
            System.out.println("Invalid input. Please provide 5 parts separated by commas.");
            return null;
        }

        // Extract each part and trim whitespace.
        String articleName = parts[0].trim();
        String articleDescription = parts[1].trim();
        String orderNumber = parts[2].trim();
        double value = Double.parseDouble(parts[3].trim());
        String orderedBy = parts[4].trim();

        // Return a new Article object with the parsed values
        return new Article(articleName, articleDescription, orderNumber, value, orderedBy);
    }
}
