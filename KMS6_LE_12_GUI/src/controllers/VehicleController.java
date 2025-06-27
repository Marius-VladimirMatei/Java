package controllers;

import java.util.List;

import models.Vehicle;

public class VehicleController {
    private List<Vehicle> fleet;
    private FleetManager fleetManager;

    public VehicleController(List<Vehicle> fleet, FleetManager fleetManager) {
        this.fleet = fleet;
        this.fleetManager = fleetManager;
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
        fleetManager.saveFleet();
        System.out.println("Vehicle added successfully!");
    }

    public void displayFleetDetails() {
        int index = 1;
        System.out.println("\nFleet Details (Total Vehicles: " + fleet.size() + "):");

        if (fleet.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
            return;
        }

        for (Vehicle vehicle : fleet) {
            System.out.println(index++ + " " + vehicle.getDetails());
        }
        System.out.println();
    }
}