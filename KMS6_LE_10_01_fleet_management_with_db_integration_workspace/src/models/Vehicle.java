package models;

public abstract class Vehicle {
    // Class attribute (shared across all vehicles)
    private static int totalVehicles = 0;

    // Instance attributes
    private String licensePlate;
    private double mileage;
    private double fuelLevel;

    // Constructor
    public Vehicle(String licensePlate, double mileage, double fuelLevel) {
        this.licensePlate = licensePlate;
        this.mileage = mileage;
        this.fuelLevel = fuelLevel;
        totalVehicles++; // Increment total vehicles when a new vehicle is created
    }

    // Abstract method to be implemented by subclasses
    public abstract void refuel(double amount);

    // Method to update mileage
    public void updateMileage(double distance) {
        this.mileage += distance;
        System.out.println("Mileage updated for " + licensePlate + ". New mileage: " + mileage);
    }

    // Get vehicle details
    public String getDetails() {
        return "Type: " + this.getClass().getSimpleName() + " License Plate: " + licensePlate + ", Mileage: " + mileage
                + ", Fuel Level: " + fuelLevel;
    }

    // Getter for totalVehicles
    public static int getTotalVehicles() {
        return totalVehicles;
    }

    // Getters for instance attributes
    public String getLicensePlate() {
        return licensePlate;
    }

    public double getMileage() {
        return mileage;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    // Setter for fuelLevel
    protected void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
}
