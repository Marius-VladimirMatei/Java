package controllers;

import java.util.ArrayList;
import java.util.List;

import data_persistance.Storage;
import models.Bicycle;
import models.Vehicle;

public class FleetManager {
    private List<Vehicle> fleet;
    private Storage storage;

    public FleetManager(Storage storage) {
        this.storage = storage;
        // Assign the loaded fleet to this.fleet
        this.fleet = storage.loadFleetFromCSV();
        // If there are no vehicles loaded from CSV, then ensure fleet is not null.
        if (this.fleet == null) {
            this.fleet = new ArrayList<>();
        }
    }

    // Refuels the vehicle identified by license plate
    public void refuelVehicle(String licensePlate, double amount) {
        Vehicle vehicle = findVehicleByLicensePlate(licensePlate);
        if (vehicle != null) {
            if (vehicle instanceof Bicycle) {
                vehicle.refuel(0); // Bicycles don't need fuel
            } else {
                vehicle.refuel(amount);
            }
            storage.saveFleetToCSV(fleet);
        } else {
            System.out.println("Vehicle not found!");
        }
    }

    // Updates the mileage of the vehicle identified by license plate
    public void updateMileage(String licensePlate, double distance) {
        Vehicle vehicle = findVehicleByLicensePlate(licensePlate);
        if (vehicle != null) {
            vehicle.updateMileage(distance);
            storage.saveFleetToCSV(fleet);
        } else {
            System.out.println("Vehicle not found!");
        }
    }

    // Searches for a vehicle by license plate
    private Vehicle findVehicleByLicensePlate(String licensePlate) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                return vehicle;
            }
        }
        return null;
    }

    public List<Vehicle> getFleet() {
        return fleet;
    }

    public void saveFleet() {
        storage.saveFleetToCSV(fleet);
    }

}