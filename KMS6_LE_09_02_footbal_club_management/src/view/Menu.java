package view;

import controllers.InputHandler;
import data_persistance.Storage;

public class Menu {
    private InputHandler inputHandler;
    private Storage storage;

    public Menu(InputHandler inputHandler, Storage storage) {
        this.inputHandler = inputHandler;
        this.storage = storage;
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = inputHandler.getMenuChoice();
            switch (choice) {
                case 1:
                    inputHandler.handleAddTeam();
                    break;
                case 2:
                    inputHandler.handleDisplayTeamDetails();
                    break;
                case 3:
                    inputHandler.handleManagePlayers(storage);
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n=== Football Club Management System ===");
        System.out.println("1. Add a team");
        System.out.println("2. Display team details");
        System.out.println("3. Manage players");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
}