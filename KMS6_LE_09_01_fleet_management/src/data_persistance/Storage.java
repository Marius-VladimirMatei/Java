package data_persistance;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import models.Bicycle;
import models.Car;
import models.Motorcycle;
import models.Truck;
import models.Vehicle;

public class Storage {
    private static final String CSV_FILE = "fleet.csv";

    // Saves the fleet to a CSV file
    public void saveFleetToCSV(List<Vehicle> fleet) {
        try (FileWriter writer = new FileWriter(CSV_FILE)) {
            writer.write("type,licensePlate,mileage,fuelLevel,specificAttribute\n");
            for (Vehicle vehicle : fleet) {
                StringBuilder line = new StringBuilder();
                if (vehicle instanceof Car) {
                    Car car = (Car) vehicle;
                    line.append("Car,")
                            .append(car.getLicensePlate()).append(",")
                            .append(car.getMileage()).append(",")
                            .append(car.getFuelLevel()).append(",")
                            .append(car.getNumberOfDoors());
                } else if (vehicle instanceof Truck) {
                    Truck truck = (Truck) vehicle;
                    line.append("Truck,")
                            .append(truck.getLicensePlate()).append(",")
                            .append(truck.getMileage()).append(",")
                            .append(truck.getFuelLevel()).append(",")
                            .append(truck.getCargoCapacity());
                } else if (vehicle instanceof Motorcycle) {
                    Motorcycle moto = (Motorcycle) vehicle;
                    line.append("Motorcycle,")
                            .append(moto.getLicensePlate()).append(",")
                            .append(moto.getMileage()).append(",")
                            .append(moto.getFuelLevel()).append(",")
                            .append(moto.hasSidecar());
                } else if (vehicle instanceof Bicycle) {
                    Bicycle bike = (Bicycle) vehicle;
                    line.append("Bicycle,")
                            .append(bike.getLicensePlate()).append(",")
                            .append(bike.getMileage()).append(",")
                            .append("0.0,")
                            .append(bike.isElectric());
                }
                writer.write(line.toString() + "\n");
            }
            System.out.println("Fleet saved to " + CSV_FILE);
        } catch (IOException e) {
            System.out.println("Error saving fleet to CSV: " + e.getMessage());
        }
    }

    // Loads fleet data from a CSV file
    public List<Vehicle> loadFleetFromCSV() {
        List<Vehicle> fleet = new ArrayList<>();
        File file = new File(CSV_FILE);
        if (!file.exists()) {
            return fleet;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String type = data[0];
                String licensePlate = data[1];
                double mileage = Double.parseDouble(data[2]);
                double fuelLevel = Double.parseDouble(data[3]);
                String specificAttribute = data[4];

                switch (type) {
                    case "Car":
                        int doors = Integer.parseInt(specificAttribute);
                        fleet.add(new Car(licensePlate, mileage, fuelLevel, doors));
                        break;
                    case "Truck":
                        double capacity = Double.parseDouble(specificAttribute);
                        fleet.add(new Truck(licensePlate, mileage, fuelLevel, capacity));
                        break;
                    case "Motorcycle":
                        boolean sidecar = Boolean.parseBoolean(specificAttribute);
                        fleet.add(new Motorcycle(licensePlate, mileage, fuelLevel, sidecar));
                        break;
                    case "Bicycle":
                        boolean isElectric = Boolean.parseBoolean(specificAttribute);
                        fleet.add(new Bicycle(licensePlate, mileage, isElectric));
                        break;
                }
            }
            System.out.println("Fleet loaded from " + CSV_FILE);
        } catch (IOException e) {
            System.out.println("Error loading fleet from CSV: " + e.getMessage());
        }
        return fleet;
    }
}