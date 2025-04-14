// Class designed to representa a seat

public class Seat {
    private boolean isTaken;

    public Seat() {
        this.isTaken = false;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void book() {
        this.isTaken = true;
    }

    public void release() {
        this.isTaken = false;
    }
}
