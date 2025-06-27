package view;

public class TeamView {
    public void displayTeamTypeMenu() {
        System.out.println("\nSelect team type:");
        System.out.println("1. Youth Team  2. Senior Team");
        System.out.print("Enter type (1-2): ");
    }

    public void promptForTeamName() {
        System.out.print("Enter team name: ");
    }

    public void promptForCoachName() {
        System.out.print("Enter coach name: ");
    }

    public void promptForPlayerCount() {
        System.out.print("Enter player count: ");
    }

    public void promptForAgeLimit() {
        System.out.print("Enter age limit for youth team: ");
    }

    public void promptForMinimumAge() {
        System.out.print("Enter minimum age for senior team: ");
    }

    public void displayInvalidTeamType() {
        System.out.println("Invalid team type!");
    }

    public void promptForTeamToManage() {
        System.out.print("\nEnter the name of the team to manage players: ");
    }

    public void displayTeamNotFound() {
        System.out.println("Team not found!");
    }
}