// Class designed to handle output operations for the IP Address Binary Converter.
public class OutputHandler {

    // Prints the welcome header for the application.
    public void showHeader() {
        System.out.println("IP Address Binary Converter");
        System.out.println("----------------------------");
    }

    // Displays the converted IP address.
    public void showResult(IPAddress ipAddress) {
        System.out.println(ipAddress);
    }

    // Displays an error message.
    public void showError(String message) {
        System.out.println("Error: " + message);
    }

}
