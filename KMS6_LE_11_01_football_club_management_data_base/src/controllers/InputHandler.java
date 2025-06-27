package controllers;

import java.util.Scanner;
import view.TeamView;
import view.PlayerView;
import models.Team;
import models.YouthTeam;
import models.SeniorTeam;
import models.Player;
import data_persistance.Storage;

public class InputHandler {
    private TeamController teamController;
    private TeamManager teamManager;
    private Scanner scanner;
    private TeamView teamView;
    private PlayerView playerView;

    public InputHandler(TeamController teamController, TeamManager teamManager) {
        this.teamController = teamController;
        this.teamManager = teamManager;
        this.scanner = new Scanner(System.in);
        this.teamView = new TeamView();
        this.playerView = new PlayerView();
    }

    public int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // The program is not crushing after on bad input
        }
    }

    public void handleAddTeam() {
        teamView.displayTeamTypeMenu();
        int type = getMenuChoice();

        teamView.promptForTeamName();
        String name = scanner.nextLine();
        teamView.promptForCoachName();
        String coach = scanner.nextLine();
        teamView.promptForPlayerCount();
        int playerCount = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1:
                teamView.promptForAgeLimit();
                int ageLimit = Integer.parseInt(scanner.nextLine());
                teamController.addTeam(new YouthTeam(name, coach, playerCount, ageLimit));
                break;
            case 2:
                teamView.promptForMinimumAge();
                int minimumAge = Integer.parseInt(scanner.nextLine());
                teamController.addTeam(new SeniorTeam(name, coach, playerCount, minimumAge));
                break;
            default:
                teamView.displayInvalidTeamType();
        }
    }

    public void handleDisplayTeamDetails() {
        teamController.displayTeamDetails();
    }

    public void handleManagePlayers(Storage storage) {
        teamView.promptForTeamToManage();
        String teamName = scanner.nextLine();
        Team selectedTeam = findTeamByName(teamName);

        if (selectedTeam == null) {
            teamView.displayTeamNotFound();
            return;
        }

        PlayerController playerController = new PlayerController(selectedTeam, storage);
        managePlayersMenu(playerController, selectedTeam);
    }

    private Team findTeamByName(String teamName) {
        for (Team team : teamManager.getTeams()) {
            if (team.getName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        return null;
    }

    private void managePlayersMenu(PlayerController playerController, Team selectedTeam) {
        while (true) {
            playerView.displayPlayerMenu(selectedTeam.getName());
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    handleAddPlayer(playerController);
                    break;
                case 2:
                    handleEditPlayer(playerController);
                    break;
                case 3:
                    handleRemovePlayer(playerController);
                    break;
                case 4:
                    playerController.displayPlayers();
                    break;
                case 5:
                    return;
                default:
                    playerView.displayInvalidChoice();
            }
        }
    }

    private void handleAddPlayer(PlayerController playerController) {
        playerView.promptForPlayerName();
        String name = scanner.nextLine();
        playerView.promptForPlayerPosition();
        String position = scanner.nextLine();
        playerView.promptForJerseyNumber();
        int jerseyNumber = Integer.parseInt(scanner.nextLine());
        playerController.addPlayer(new Player(name, position, jerseyNumber));
    }

    private void handleEditPlayer(PlayerController playerController) {
        playerView.promptForPlayerToEdit();
        int editJerseyNumber = Integer.parseInt(scanner.nextLine());
        playerView.promptForNewPlayerName();
        String newName = scanner.nextLine();
        playerView.promptForNewPlayerPosition();
        String newPosition = scanner.nextLine();
        playerView.promptForNewJerseyNumber();
        int newJerseyNumber = Integer.parseInt(scanner.nextLine());
        playerController.editPlayer(editJerseyNumber, newName, newPosition, newJerseyNumber);
    }

    private void handleRemovePlayer(PlayerController playerController) {
        playerView.promptForPlayerToRemove();
        int removeJerseyNumber = Integer.parseInt(scanner.nextLine());
        playerController.removePlayer(removeJerseyNumber);
    }
}