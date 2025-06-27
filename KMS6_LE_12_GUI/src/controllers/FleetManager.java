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
        this.fleet = storage.loadFleetFromDatabase();
        if (this.fleet == null) {
            this.fleet = new ArrayList<>();
        }
    }

    public String refuelVehicle(String licensePlate, double amount) {
        Vehicle v = findVehicleByLicensePlate(licensePlate);
        if (v == null) {
            return "Vehicle not found!";
        }

        String result;
        if (v instanceof Bicycle) {
            v.refuel(0);
            result = "This is a bicycle – no fuel needed.";
        } else {
            double currentFuel = v.getFuelLevel();
            double maxCapacity = v.getMaxFuelCapacity();

            if (currentFuel + amount > maxCapacity) {
                v.refuel(maxCapacity - currentFuel);
                result = "Tank filled to MAX capacity.";
            } else {
                v.refuel(amount);
                result = "Refueled " + amount + " units.";
            }
        }

        storage.saveFleetToDatabase(fleet);
        return result;
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