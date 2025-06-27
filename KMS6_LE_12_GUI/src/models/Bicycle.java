package models;

public class Bicycle extends Vehicle {
    private boolean isElectric;

    public Bicycle(String licensePlate, double mileage, boolean isElectric) {
        super(licensePlate, mileage, 0, 0); // no fuel
        this.isElectric = isElectric;
    }

    public boolean isElectric() { return isElectric; }

    @Override
    public void refuel(double amount) {
        System.out.println("Bicycle " + getLicensePlate() + " doesn’t need fuel!");
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Is Electric: " + (isElectric ? "Yes" : "No");
    }
}