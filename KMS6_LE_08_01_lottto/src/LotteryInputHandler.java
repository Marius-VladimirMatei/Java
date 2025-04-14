import java.util.Scanner;

public class LotteryInputHandler {
    private Scanner scanner;

    public LotteryInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    // Get a number from the user
    public int getNumber(int position) {
        System.out.print("Enter the " + position + ". number: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("That's not a number! Please try again.");
            return getNumber(position); // Ask again if input is invalid
        }
    }
}