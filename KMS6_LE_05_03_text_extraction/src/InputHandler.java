// Class designed to handle user input and read strings from the console

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String readStringInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
