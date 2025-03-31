public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        ColorConverter converter = new HexToRGBConverter();

        // Display header.
        outputHandler.displayHeader();

        // Process user input in an infinite loop.
        while (true) {
            String input = inputHandler.readHexCode();
            try {
                // Convert the hex code into a Color.
                Color color = converter.convert(input);
                outputHandler.displayColor(color);
            } catch (IllegalArgumentException e) {
                outputHandler.displayError(e.getMessage());
            }
            System.out.println(); // Blank line for readability.

        }
    }
}
