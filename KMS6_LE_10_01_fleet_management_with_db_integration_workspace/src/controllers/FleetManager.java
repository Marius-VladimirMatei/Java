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
        this.fleet  = storage.loadFleetFromDatabase();
        if (this.fleet == null) {
            this.fleet = new ArrayList<>();
        }
    }

    public void refuelVehicle(String licensePlate, double amount) {
        Vehicle v = findVehicleByLicensePlate(licensePlate);
        if (v != null) {
            if (v instanceof Bicycle) v.refuel(0);
            else                      v.refuel(amount);
            storage.saveFleetToDatabase(fleet);
        } else {
            System.out.println("Vehicle not found!");
        }
    }

    public void updateMileage(String licensePlate, double distance) {
        Vehicle v = findVehicleByLicensePlate(licensePlate);
        if (v != null) {
            v.updateMileage(distance);
            storage.saveFleetToDatabase(fleet);
        } else {
            System.out.println("Vehicle not found!");
        }
    }

    private Vehicle findVehicleByLicensePlate(String licensePlate) {
        for (Vehicle v : fleet) {
            if (v.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                return v;
            }
        }
        return null;
    }

    public List<Vehicle> getFleet() {
        return fleet;
    }

    public void saveFleet() {
        storage.saveFleetToDatabase(fleet);
    }
}
