package controllers;

import java.util.List;
import data_persistance.Storage;
import models.Player;
import models.Team;

public class PlayerManager {
    private Team team;
    private Storage storage;

    public PlayerManager(Team team, Storage storage) {
        this.team = team;
        this.storage = storage;
    }

    public List<Player> getPlayers() {
        return team.getPlayers();
    }

    public Team getTeam() {
        return team;
    }

    public void addPlayer(Player player) {
        team.getPlayers().add(player);
        savePlayers();
    }

    public boolean updatePlayer(int jerseyNumber, String newName, String newPosition, int newJerseyNumber) {
        for (Player player : team.getPlayers()) {
            if (player.getJerseyNumber() == jerseyNumber) {
                player.setName(newName);
                player.setPosition(newPosition);
                player.setJerseyNumber(newJerseyNumber);
                savePlayers();
                return true;
            }
        }
        return false;
    }

    public boolean removePlayer(int jerseyNumber) {
        List<Player> players = team.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getJerseyNumber() == jerseyNumber) {
                players.remove(i);
                savePlayers();
                return true;
            }
        }
        return false;
    }

    public void savePlayers() {
        storage.savePlayersToCSV(team);
    }
}