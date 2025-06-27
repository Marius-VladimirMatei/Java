// views/VehicleDialogFactory.java
package views;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import models.*;
import java.util.Optional;

public class VehicleDialogFactory {
    public static Optional<Vehicle> createAddVehicleDialog() {
        Dialog<Vehicle> dialog = new Dialog<>();
        dialog.setTitle("Add Vehicle");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane(); grid.setHgap(10); grid.setVgap(10);

        ChoiceBox<String> typeBox = new ChoiceBox<>();
        typeBox.getItems().addAll("Car","Truck","Motorcycle","Bicycle");
        typeBox.setValue("Car");

        TextField plate = new TextField();
        TextField mileage = new TextField();
        TextField fuel = new TextField();
        TextField maxCap = new TextField();
        TextField extraField = new TextField();
        CheckBox extraCheck = new CheckBox();
        Label extraLabel = new Label("Number of Doors:");
        Label maxLabel = new Label("Max Fuel Capacity:");

        grid.addRow(0,new Label("Type:"),typeBox);
        grid.addRow(1,new Label("Plate:"),plate);
        grid.addRow(2,new Label("Mileage:"),mileage);
        grid.addRow(3,new Label("Fuel Level:"),fuel);
        grid.addRow(4,maxLabel,maxCap);
        grid.addRow(5,extraLabel,extraField);
        grid.addRow(6,new Label(),extraCheck);

        // INITIAL VISIBILITY
        extraCheck.setVisible(false);
        extraField.setVisible(true);

        // update UI when type changes
        typeBox.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv)->{
            boolean isBicycle = "Bicycle".equals(nv);
            fuel.setDisable(isBicycle);
            maxCap.setDisable(isBicycle);

            switch(nv) {
                case "Car" -> {
                    extraLabel.setText("Number of Doors:");
                    extraField.setVisible(true);
                    extraCheck.setVisible(false);
                }
                case "Truck" -> {
                    extraLabel.setText("Cargo Capacity (tons):");
                    extraField.setVisible(true);
                    extraCheck.setVisible(false);
                }
                case "Motorcycle" -> {
                    extraLabel.setText("Has Sidecar:");
                    extraField.setVisible(false);
                    extraCheck.setVisible(true);
                }
                case "Bicycle" -> {
                    extraLabel.setText("Is Electric:");
                    extraField.setVisible(false);
                    extraCheck.setVisible(true);
                }
            }
        });

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(btn -> {
            try {
                String t = typeBox.getValue();
                String p = plate.getText();
                double m = Double.parseDouble(mileage.getText());
                double f = fuel.isDisabled()?0:Double.parseDouble(fuel.getText());
                double mc= maxCap.isDisabled()?0:Double.parseDouble(maxCap.getText());

                return switch(t) {
                    case "Car" -> new Car(p,m,f,Integer.parseInt(extraField.getText()),mc);
                    case "Truck" -> new Truck(p,m,f,Double.parseDouble(extraField.getText()),mc);
                    case "Motorcycle" -> new Motorcycle(p,m,f,extraCheck.isSelected(),mc);
                    case "Bicycle" -> new Bicycle(p,m,extraCheck.isSelected());
                    default -> null;
                };
            } catch(Exception e) { return null; }
        });

        return dialog.showAndWait();
    }
}
