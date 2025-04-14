// Class designed to represent a cinema with multiple rows of seats

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cinema {
    private List<Row> rows;

    public Cinema(int rowCount, int seatsPerRow) {
        rows = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            rows.add(new Row(seatsPerRow, i + 1));
        }
    }

    // Prints the seating chart of the cinema.
    // Each row is represented by a series of O (free) and X (occupied) symbols.
    public void printSeatingChart() {
        for (Row row : rows) {
            // Print seat statuses.
            for (Seat seat : row.getSeats()) {
                System.out.print(seat.isTaken() ? " X " : " O ");
            }
            // Append row number and free seat count.
            System.out.println("  <- Row " + row.getRowNumber() +
                    " (" + row.countFreeSeats() + " free seats)");
        }
    }

    // Method to iterate through each row and counts the number of free seats.
    public void printFreeSeatsPerRow() {
        for (Row row : rows) {
            int free = row.countFreeSeats();
            System.out.println(free + " free seats in Row " + row.getRowNumber());
        }
    }

    public double calculateOccupiedPercentage() {
        int total = 0;
        int occupied = 0;
        for (Row row : rows) {
            for (Seat seat : row.getSeats()) {
                total++;
                if (seat.isTaken()) {
                    occupied++;
                }
            }
        }
        return (double) occupied / total * 100;
    }

    // Randomly occupies 'count' seats in the cinema.
    public void randomlyOccupySeats(int count) { // count is the number of seats to occupy
        int totalSeats = rows.size() * rows.get(0).getSeats().size();
        if (count > totalSeats) {
            count = totalSeats;
        }

        // Random number generator to select random seats.
        Random random = new Random();
        int occupied = 0;
        while (occupied < count) {
            int rowIndex = random.nextInt(rows.size());
            Row row = rows.get(rowIndex);
            int seatIndex = random.nextInt(row.getSeats().size());
            Seat seat = row.getSeats().get(seatIndex);
            if (!seat.isTaken()) {
                seat.book();
                occupied++;
            }
        }
    }
}
