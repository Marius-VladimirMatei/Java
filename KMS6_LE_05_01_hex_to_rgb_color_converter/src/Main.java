public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        ColorConverter converter = new HexToRGBConverter();

        // Main loop with menu.
        while (true) {
            outputHandler.displayMenu();
            String choice = inputHandler.readMenuChoice();

            if (choice.equals("2")) {
                outputHandler.displayExitMessage();
                break;
            } else if (choice.equals("1")) {
                String hexInput = inputHandler.readHexCode();
                try {
                    Color color = converter.convert(hexInput);
                    outputHandler.displayColor(color);
                } catch (IllegalArgumentException e) {
                    outputHandler.displayError(e.getMessage());
                }
            } else {
                outputHandler.displayError("Invalid selection. Please try again.");
            }
            System.out.println(); // Blank line for readability.
        }
        inputHandler.close();
    }
}
