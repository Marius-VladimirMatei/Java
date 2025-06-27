package view;

public class PlayerView {
    public void displayPlayerMenu(String teamName) {
        System.out.println("\n=== Manage Players for " + teamName + " ===");
        System.out.println("1. Add a player");
        System.out.println("2. Edit a player");
        System.out.println("3. Remove a player");
        System.out.println("4. Display players");
        System.out.println("5. Back to main menu");
        System.out.print("Enter your choice: ");
    }

    public void promptForPlayerName() {
        System.out.print("Enter player name: ");
    }

    public void promptForPlayerPosition() {
        System.out.print("Enter player position: ");
    }

    public void promptForJerseyNumber() {
        System.out.print("Enter jersey number: ");
    }

    public void promptForPlayerToEdit() {
        System.out.print("Enter jersey number of player to edit: ");
    }

    public void promptForNewPlayerName() {
        System.out.print("Enter new player name: ");
    }

    public void promptForNewPlayerPosition() {
        System.out.print("Enter new player position: ");
    }

    public void promptForNewJerseyNumber() {
        System.out.print("Enter new jersey number: ");
    }

    public void promptForPlayerToRemove() {
        System.out.print("Enter jersey number of player to remove: ");
    }

    public void displayInvalidChoice() {
        System.out.println("Invalid choice! Please enter a number between 1 and 5.");
    }
}