import controllers.InputHandler;
import data_persistance.Storage;
import controllers.TeamController;
import controllers.TeamManager;
import view.*;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        TeamManager teamManager = new TeamManager(storage);
        TeamController teamController = new TeamController(teamManager.getTeams(), teamManager);
        InputHandler inputHandler = new InputHandler(teamController, teamManager);
        Menu menu = new Menu(inputHandler, storage);
        menu.start();
    }
}