package views;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class UpdateMileageDialogFactory {
    public record MileageUpdate(String licensePlate, double distance) {}

    public static Optional<MileageUpdate> createMileageDialog() {
        Dialog<MileageUpdate> dialog = new Dialog<>();
        dialog.setTitle("Update Mileage");
        dialog.setHeaderText("Enter mileage update");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField plate = new TextField();
        TextField distance = new TextField();

        grid.addRow(0, new Label("License Plate:"), plate);
        grid.addRow(1, new Label("Distance Traveled:"), distance);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(button -> {
            try {
                return new MileageUpdate(plate.getText(), Double.parseDouble(distance.getText()));
            } catch (Exception e) {
                return null;
            }
        });

        return dialog.showAndWait();
    }
}
