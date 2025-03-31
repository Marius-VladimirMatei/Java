// Handles output for the application.
public class OutputHandler {

    public void displayHeader() {
        System.out.println("Hex to RGB Converter");
        System.out.println("--------------------");
    }

    public void displayColor(Color color) {
        System.out.println("Converted color: " + color);
    }

    public void displayError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }
}
