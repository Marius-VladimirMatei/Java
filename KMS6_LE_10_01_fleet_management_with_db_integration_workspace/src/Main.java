import controllers.FleetManager;
import controllers.InputHandler;
import controllers.VehicleController;
import data_persistance.Storage;
import views.Menu;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();                        // ← create Storage
        FleetManager fleetManager = new FleetManager(storage);  // ← pass it in
        VehicleController vehicleController =
                new VehicleController(fleetManager.getFleet(), fleetManager);
        InputHandler inputHandler = new InputHandler(vehicleController, fleetManager);
        new Menu(inputHandler).start();
    }
}
