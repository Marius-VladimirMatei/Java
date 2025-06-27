package models;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String licensePlate, double mileage, double fuelLevel, int numberOfDoors, double maxFuelCapacity) {
        super(licensePlate, mileage, fuelLevel, maxFuelCapacity);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() { return numberOfDoors; }

    @Override
    public void refuel(double amount) {
        setFuelLevel(Math.min(getFuelLevel() + amount, maxFuelCapacity));
        System.out.println("Car " + getLicensePlate() + " refueled. New fuel level: " + getFuelLevel());
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Number of Doors: " + numberOfDoors;
    }
}