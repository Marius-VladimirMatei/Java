package models;

public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String licensePlate, double mileage, double fuelLevel, boolean hasSidecar, double maxFuelCapacity) {
        super(licensePlate, mileage, fuelLevel, maxFuelCapacity);
        this.hasSidecar = hasSidecar;
    }

    public boolean hasSidecar() { return hasSidecar; }

    @Override
    public void refuel(double amount) {
        setFuelLevel(Math.min(getFuelLevel() + amount, maxFuelCapacity));
        System.out.println("Motorcycle " + getLicensePlate() + " refueled. New fuel level: " + getFuelLevel());
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Has Sidecar: " + (hasSidecar ? "Yes" : "No");
    }
}