// Class designed to represent a row of seats

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Seat> seats;
    private int rowNumber;

    public Row(int seatCount, int rowNumber) {
        this.rowNumber = rowNumber;
        this.seats = new ArrayList<>();
        for (int i = 0; i < seatCount; i++) {
            seats.add(new Seat());
        }
    }



    public int countFreeSeats() {
        // Initialize counter to 0
        int free = 0;
        for (Seat seat : seats) { // loop through the array of seats and check if seat isTaken => increment the free seat counter
            if (!seat.isTaken()) {
                free++;
            }
        }
        return free;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public int getRowNumber() {
        return rowNumber;
    }
}
