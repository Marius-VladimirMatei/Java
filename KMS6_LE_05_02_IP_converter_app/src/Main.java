public class Main {

    public static void main(String[] args) {
        // Use the converter to parse a dotted-decimal input.
        IPAddressConverter converter = new DottedDecimalToIPConverter();
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        outputHandler.showHeader();

        while (true) {
            String input = inputHandler.getInput("Enter an IP address (e.g. 192.168.1.1): ");

            try {
                IPAddress ipAddress = converter.convert(input);
                // Display the result using OutputHandler.
                outputHandler.showResult(ipAddress);
            } catch (IllegalArgumentException e) {
                // Display the error message using OutputHandler.
                outputHandler.showError(e.getMessage());
            }

        }
    }
}
