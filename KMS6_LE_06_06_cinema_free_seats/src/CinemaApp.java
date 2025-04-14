import java.util.Scanner;

public class CinemaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create a cinema with "default" 9 rows and 10 seats per row"".
        Cinema cinema = new Cinema(10, 10);

        // Prompt user for how many seats should be initially occupied.
        System.out.print("Enter the number of seats to be initially occupied: ");
        int initialOccupied = scanner.nextInt();
        cinema.randomlyOccupySeats(initialOccupied);

        boolean running = true;
        while (running) {
            System.out.println("\nCinema Seat Booking System");
            System.out.println("1. Show Seating Chart");
            System.out.println("2. Show Free Seats Per Row");
            System.out.println("3. Show Occupied Percentage");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    cinema.printSeatingChart();
                    break;
                case 2:
                    cinema.printFreeSeatsPerRow();
                    break;
                case 3:
                    System.out.printf("Occupied percentage: %.2f%%\n", cinema.calculateOccupiedPercentage());
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}
