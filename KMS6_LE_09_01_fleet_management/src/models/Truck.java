package models;

public class Truck extends Vehicle {
    private double cargoCapacity;

    // Constructor
    public Truck(String licensePlate, double mileage, double fuelLevel, double cargoCapacity) {
        super(licensePlate, mileage, fuelLevel);
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    // Implement refuel
    @Override
    public void refuel(double amount) {
        setFuelLevel(getFuelLevel() + amount);
        System.out.println("Truck " + getLicensePlate() + " refueled. New fuel level: " + getFuelLevel());
    }

    // Include truck-specific details
    @Override
    public String getDetails() {
        return super.getDetails() + ", Cargo Capacity: " + cargoCapacity + " tons";
    }
}
