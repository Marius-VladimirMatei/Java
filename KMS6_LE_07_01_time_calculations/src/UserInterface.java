import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class UserInterface {
    private final TimeInput timeInput = new TimeInput();
    private final WorkTimeCalculator workCalculator = new WorkTimeCalculator();
    private final OrderDeliveryCalculator orderCalculator = new OrderDeliveryCalculator();
    private final DurationFormatter formatter = new DurationFormatter();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("===== Menu =====");
            System.out.println("1. Calculate Work Time");
            System.out.println("2. Calculate Order to Delivery Time");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");

            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                continue;
            }

            switch (choice) {
                case 1:
                    // Option for calculating work session duration.
                    System.out.println("\nWork Time Calculation:");
                    LocalDateTime start = timeInput.readDateTime("Enter start time");
                    LocalDateTime end = timeInput.readDateTime("Enter end time");
                    System.out.println("Worked time: " +
                            formatter.format(workCalculator.calculateWorkDuration(start, end)));
                    System.out.println();
                    break;
                case 2:
                    // Option for calculating the days between order and delivery.
                    System.out.println("\nOrder to Delivery Time Calculation:");
                    // Read dates for order and delivery, converting to LocalDate via toLocalDate()
                    LocalDate orderDate = timeInput.readDateTime("Enter order date").toLocalDate();
                    LocalDate deliveryDate = timeInput.readDateTime("Enter delivery date").toLocalDate();
                    long daysBetween = orderCalculator.calculateDaysBetween(orderDate, deliveryDate);
                    System.out.println("Days between order and delivery: " + daysBetween + " day(s)");
                    System.out.println();
                    break;
                case 3:
                    // Exit the application.
                    System.out.println("Exiting the application.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select option 1, 2, or 3.");
                    break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.run();
    }
}
