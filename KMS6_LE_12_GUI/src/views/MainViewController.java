package views;

import controllers.FleetManager;
import controllers.VehicleController;
import data_persistance.Storage;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.*;

public class MainViewController {
    @FXML private TableView<Vehicle> fleetTable;
    @FXML private TableColumn<Vehicle, String> typeColumn;
    @FXML private TableColumn<Vehicle, String> licenseColumn;
    @FXML private TableColumn<Vehicle, Double> mileageColumn;
    @FXML private TableColumn<Vehicle, Double> fuelLevelColumn;
    @FXML private TableColumn<Vehicle, Double> maxCapacityColumn;
    @FXML private TableColumn<Vehicle, Object> doorsColumn;
    @FXML private TableColumn<Vehicle, Object> cargoColumn;
    @FXML private TableColumn<Vehicle, Object> sidecarColumn;
    @FXML private TableColumn<Vehicle, Object> electricColumn;

    private FleetManager fleetManager;
    private VehicleController vehicleController;

    @FXML
    public void initialize() {
        Storage storage = new Storage();
        fleetManager = new FleetManager(storage);
        vehicleController = new VehicleController(fleetManager.getFleet(), fleetManager);

        typeColumn.setCellValueFactory(c -> new ReadOnlyObjectWrapper<>(c.getValue().getClass().getSimpleName()));
        licenseColumn.setCellValueFactory(c -> new ReadOnlyObjectWrapper<>(c.getValue().getLicensePlate()));
        mileageColumn.setCellValueFactory(c -> new ReadOnlyObjectWrapper<>(c.getValue().getMileage()));
        fuelLevelColumn.setCellValueFactory(c -> new ReadOnlyObjectWrapper<>(c.getValue().getFuelLevel()));
        maxCapacityColumn.setCellValueFactory(c -> new ReadOnlyObjectWrapper<>(c.getValue().getMaxFuelCapacity()));
        doorsColumn.setCellValueFactory(c -> {
            if (c.getValue() instanceof Car car) return new ReadOnlyObjectWrapper<>(car.getNumberOfDoors());
            else return new ReadOnlyObjectWrapper<>(null);
        });
        cargoColumn.setCellValueFactory(c -> {
            if (c.getValue() instanceof Truck truck) return new ReadOnlyObjectWrapper<>(truck.getCargoCapacity());
            else return new ReadOnlyObjectWrapper<>(null);
        });
        sidecarColumn.setCellValueFactory(c -> {
            if (c.getValue() instanceof Motorcycle moto) return new ReadOnlyObjectWrapper<>(moto.hasSidecar());
            else return new ReadOnlyObjectWrapper<>(null);
        });
        electricColumn.setCellValueFactory(c -> {
            if (c.getValue() instanceof Bicycle bike) return new ReadOnlyObjectWrapper<>(bike.isElectric());
            else return new ReadOnlyObjectWrapper<>(null);
        });

        loadFleetIntoTable();
    }

    @FXML
    private void loadFleetIntoTable() {
        ObservableList<Vehicle> list = FXCollections.observableArrayList(fleetManager.getFleet());
        fleetTable.setItems(list);
        fleetTable.refresh();
    }

    @FXML
    private void showRefuelDialog() {
        RefuelDialogFactory.createRefuelDialog().ifPresent(refuel -> {
            String message = fleetManager.refuelVehicle(refuel.licensePlate(), refuel.amount());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Refuel Status");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
            loadFleetIntoTable();
        });
    }

    @FXML
    private void showAddVehicleDialog() {
        VehicleDialogFactory.createAddVehicleDialog().ifPresent(vehicle -> {
            vehicleController.addVehicle(vehicle);
            loadFleetIntoTable();
        });
    }

    @FXML
    private void showUpdateMileageDialog() {
        UpdateMileageDialogFactory.createMileageDialog().ifPresent(update -> {
            fleetManager.updateMileage(update.licensePlate(), update.distance());
            loadFleetIntoTable();
        });
    }

    @FXML
    private void exitApplication() {
        System.exit(0);
    }
}
