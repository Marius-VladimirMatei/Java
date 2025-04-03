import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public String getInput() {
        return scanner.nextLine().trim();
    }

    public void close() {
        scanner.close();
    }
}
