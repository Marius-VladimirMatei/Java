package views;

import controllers.InputHandler;

public class Menu {
    private InputHandler inputHandler;

    public Menu(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = inputHandler.getMenuChoice();
            switch (choice) {
                case 1:
                    inputHandler.handleAddVehicle();
                    break;
                case 2:
                    inputHandler.handleRefuelVehicle();
                    break;
                case 3:
                    inputHandler.handleUpdateMileage();
                    break;
                case 4:
                    inputHandler.handleDisplayFleetDetails();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n=== Fleet Management System ===");
        System.out.println("1. Add a vehicle");
        System.out.println("2. Refuel a vehicle");
        System.out.println("3. Update mileage");
        System.out.println("4. Display fleet details");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
}