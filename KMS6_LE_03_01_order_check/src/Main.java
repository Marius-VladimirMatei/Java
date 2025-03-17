import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputValidator validator = new InputValidator(scanner);

        // Input prompt for description
        String description = validator.getValidatedDescription();

        // Input prompt for quantity
        int quantity = validator.getValidatedInteger();

        // Input prompt for unit price
        double unitPrice = validator.getValidatedDouble();

        // Create a new object of type OrderRecord
        OrderRecord record = new OrderRecord(description, quantity, unitPrice);

        System.out.println("New order Record: ");
        System.out.println(record);

        scanner.close();

    }
}