// Handles output for the application.
public class OutputHandler {

    // Displays the menu to the user.
    public void displayMenu() {
        System.out.println("Hex to RGB Converter");
        System.out.println("--------------------");
        System.out.println("Menu:");
        System.out.println("1. Convert hex color code to RGB");
        System.out.println("2. Exit");
    }

    public void displayColor(Color color) {
        System.out.println("Converted color: " + color);
    }

    public void displayError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    public void displayExitMessage() {
        System.out.println("Exiting program. Goodbye!");
    }
}
