package views;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class RefuelDialogFactory {
    public record RefuelInput(String licensePlate, double amount) {}

    public static Optional<RefuelInput> createRefuelDialog() {
        Dialog<RefuelInput> dialog = new Dialog<>();
        dialog.setTitle("Refuel Vehicle");
        dialog.setHeaderText("Enter refuel details");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField plate = new TextField();
        TextField amount = new TextField();

        grid.addRow(0, new Label("License Plate:"), plate);
        grid.addRow(1, new Label("Fuel Amount:"), amount);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(button -> {
            try {
                return new RefuelInput(plate.getText(), Double.parseDouble(amount.getText()));
            } catch (Exception e) {
                return null;
            }
        });

        return dialog.showAndWait();
    }
}
