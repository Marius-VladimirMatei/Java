package models;

public class Bicycle extends Vehicle {
    private boolean isElectric;

    // Constructor
    public Bicycle(String licensePlate, double mileage, boolean isElectric) {
        super(licensePlate, mileage, 0); // Bicycles don’t use fuel
        this.isElectric = isElectric;
    }

    public boolean isElectric() {
        return isElectric;
    }

    // Dummy implementation for refuel
    @Override
    public void refuel(double amount) {
        System.out.println("Bicycle " + getLicensePlate() + " doesn’t need fuel!");
    }

    // Get detailed description
    @Override
    public String getDetails() {
        return super.getDetails() + ", Is Electric: " + (isElectric ? "Yes" : "No");
    }
}
