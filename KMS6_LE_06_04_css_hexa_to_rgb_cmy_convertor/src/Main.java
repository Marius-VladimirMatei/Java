public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        while (true) {
            // Ask the user for the color mode.
            outputHandler.print("Select input mode:");
            outputHandler.print("1. CSS Hex Code");
            outputHandler.print("2. RGB values");
            outputHandler.print("3. Exit");
            outputHandler.print("Enter mode (1, 2, or 3):");
            String mode = inputHandler.getInput();

            // Exit condition.
            if (mode.equals("3")) {
                outputHandler.print("Exiting program. Goodbye!");
                break;
            }

            RGBColor color = null;
            String input = "";

            try {
                if (mode.equals("1")) {
                    outputHandler.print("Enter a CSS color code (e.g. #f0c, #ff00cc, #f0ca, #ff00ccaa):");
                    input = inputHandler.getInput();
                    color = HexToRGBConverter.convert(input);

                    // Output CSS code and its corresponding RGB values.
                    outputHandler.print("Original CSS color code: " + input);
                    outputHandler.print("RGB values: Red = " + color.getRed() + ", Green = "
                            + color.getGreen() + ", Blue = " + color.getBlue());
                } else if (mode.equals("2")) {
                    outputHandler.print("Enter RGB values separated by spaces or commas (e.g. 255,0,204 or 255 0 204):");
                    input = inputHandler.getInput();
                    color = RGBInputConverter.convert(input);
                    // No RGB values are output when user chooses RGB input.
                } else {
                    outputHandler.printError("Invalid mode selected. Please try again.");
                    outputHandler.print("\n--------------------------------\n");
                    continue; // Restart loop on invalid input.
                }

                // Convert the RGB color to CMY.
                CMYColor cmy = CMYConverter.convert(color);

                outputHandler.print("Converted CMY values:");
                outputHandler.print(String.format("Cyan = %.2f%%", cmy.getCyan()));
                outputHandler.print(String.format("Magenta = %.2f%%", cmy.getMagenta()));
                outputHandler.print(String.format("Yellow = %.2f%%", cmy.getYellow()));
            } catch (IllegalArgumentException e) {
                outputHandler.printError(e.getMessage());
            }

            // Add a separator before starting the next iteration.
            outputHandler.print("\n--------------------------------\n");
        }

        inputHandler.close();
    }
}
