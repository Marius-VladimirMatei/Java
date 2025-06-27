package controllers;

import data_persistance.Storage;
import models.Player;
import models.Team;

import java.util.List;

public class PlayerController {
    private PlayerManager playerManager;

    public PlayerController(Team team, Storage storage) {
        this.playerManager = new PlayerManager(team, storage);
    }

    public void addPlayer(Player player) {
        playerManager.addPlayer(player);
        System.out.println("Player added successfully!");
    }

    public void editPlayer(int jerseyNumber, String newName, String newPosition, int newJerseyNumber) {
        if (playerManager.updatePlayer(jerseyNumber, newName, newPosition, newJerseyNumber)) {
            System.out.println("Player updated successfully!");
        } else {
            System.out.println("Player with jersey number " + jerseyNumber + " not found!");
        }
    }

    public void removePlayer(int jerseyNumber) {
        if (playerManager.removePlayer(jerseyNumber)) {
            System.out.println("Player removed successfully!");
        } else {
            System.out.println("Player with jersey number " + jerseyNumber + " not found!");
        }
    }

    public void displayPlayers() {
        List<Player> players = playerManager.getPlayers();
        System.out.println(
                "\nPlayers for " + playerManager.getTeam().getName() + " (Total Players: " + players.size() + "):");
        if (players.isEmpty()) {
            System.out.println("No players in this team.");
            return;
        }
        int index = 1;
        for (Player player : players) {
            System.out.println(index++ + " " + player.getDetails());
        }
        System.out.println();
    }
}