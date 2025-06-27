package models;

public class Truck extends Vehicle {
    private double cargoCapacity;

    public Truck(String licensePlate, double mileage, double fuelLevel, double cargoCapacity, double maxFuelCapacity) {
        super(licensePlate, mileage, fuelLevel, maxFuelCapacity);
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity() { return cargoCapacity; }

    @Override
    public void refuel(double amount) {
        setFuelLevel(Math.min(getFuelLevel() + amount, maxFuelCapacity));
        System.out.println("Truck " + getLicensePlate() + " refueled. New fuel level: " + getFuelLevel());
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Cargo Capacity: " + cargoCapacity + " tons";
    }
}