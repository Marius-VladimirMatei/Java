package controllers;

import java.util.Scanner;

import models.Bicycle;
import models.Car;
import models.Motorcycle;
import models.Truck;

public class InputHandler {
    private VehicleController vehicleController;
    private FleetManager fleetManager;
    private Scanner scanner;

    public InputHandler(VehicleController vehicleController, FleetManager fleetManager) {
        this.vehicleController = vehicleController;
        this.fleetManager = fleetManager;
        this.scanner = new Scanner(System.in);
    }

    public int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void handleAddVehicle() {
        System.out.println("\nSelect vehicle type:");
        System.out.println("1. Car  2. Truck  3. Motorcycle  4. Bicycle");
        System.out.print("Enter type (1-4): ");
        int type = getMenuChoice();

        System.out.print("Enter license plate: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Enter current mileage: ");
        double mileage = Double.parseDouble(scanner.nextLine());

        switch (type) {
            case 1 -> {
                System.out.print("Enter number of doors: ");
                int doors = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter current fuel level: ");
                double fuel = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter max fuel capacity: ");
                double maxCap = Double.parseDouble(scanner.nextLine());
                vehicleController.addVehicle(new Car(licensePlate, mileage, fuel, doors, maxCap));
            }
            case 2 -> {
                System.out.print("Enter cargo capacity (tons): ");
                double cargo = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter current fuel level: ");
                double fuel = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter max fuel capacity: ");
                double maxCap = Double.parseDouble(scanner.nextLine());
                vehicleController.addVehicle(new Truck(licensePlate, mileage, fuel, cargo, maxCap));
            }
            case 3 -> {
                System.out.print("Has sidecar? (yes/no): ");
                boolean sidecar = scanner.nextLine().equalsIgnoreCase("yes");
                System.out.print("Enter current fuel level: ");
                double fuel = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter max fuel capacity: ");
                double maxCap = Double.parseDouble(scanner.nextLine());
                vehicleController.addVehicle(new Motorcycle(licensePlate, mileage, fuel, sidecar, maxCap));
            }
            case 4 -> {
                System.out.print("Is it electric? (yes/no): ");
                boolean isElectric = scanner.nextLine().equalsIgnoreCase("yes");
                vehicleController.addVehicle(new Bicycle(licensePlate, mileage, isElectric));
            }
            default -> System.out.println("Invalid vehicle type!");
        }
    }

    public void handleRefuelVehicle() {
        System.out.print("\nEnter license plate of vehicle to refuel: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Enter amount of fuel to add (if applicable): ");
        double amount = 0;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            amount = 0;
        }
        fleetManager.refuelVehicle(licensePlate, amount);
    }

    public void handleUpdateMileage() {
        System.out.print("\nEnter license plate of vehicle to update mileage: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Enter distance traveled: ");
        double distance = Double.parseDouble(scanner.nextLine());
        fleetManager.updateMileage(licensePlate, distance);
    }

    public void handleDisplayFleetDetails() {
        vehicleController.displayFleetDetails();
    }

}