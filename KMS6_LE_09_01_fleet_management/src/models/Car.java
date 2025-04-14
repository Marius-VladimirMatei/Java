package models;

public class Car extends Vehicle {
    private int numberOfDoors;

    // Constructor
    public Car(String licensePlate, double mileage, double fuelLevel, int numberOfDoors) {
        super(licensePlate, mileage, fuelLevel);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    // Implement refuel
    @Override
    public void refuel(double amount) {
        setFuelLevel(getFuelLevel() + amount);
        System.out.println("Car " + getLicensePlate() + " refueled. New fuel level: " + getFuelLevel());
    }

    // Include car-specific details
    @Override
    public String getDetails() {
        return super.getDetails() + ", Number of Doors: " + numberOfDoors;
    }
}
