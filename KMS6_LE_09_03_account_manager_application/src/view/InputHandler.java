package view;

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner = new Scanner(System.in);

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }

    public String readAccountType() {
        while (true) {
            String type = readString("Enter account type (credit/debit): ").toLowerCase();
            if (type.equals("credit") || type.equals("debit")) return type;
            System.out.println("Invalid type, please enter 'credit' or 'debit'.");
        }
    }

    public void close() {
        scanner.close();
    }
}