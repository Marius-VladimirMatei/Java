package models;

public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    // Constructor
    public Motorcycle(String licensePlate, double mileage, double fuelLevel, boolean hasSidecar) {
        super(licensePlate, mileage, fuelLevel);
        this.hasSidecar = hasSidecar;
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }

    // Implement refuel
    @Override
    public void refuel(double amount) {
        setFuelLevel(getFuelLevel() + amount);
        System.out.println("Motorcycle " + getLicensePlate() + " refueled. New fuel level: " + getFuelLevel());
    }

    // Include motorcycle-specific details
    @Override
    public String getDetails() {
        return super.getDetails() + ", Has Sidecar: " + (hasSidecar ? "Yes" : "No");
    }
}
