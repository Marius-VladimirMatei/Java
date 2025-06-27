package controllers;

import java.util.List;
import data_persistance.Storage;   // note package name change
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
        storage.savePlayers(team);   // now saves only this team's players
    }

    public boolean updatePlayer(int jerseyNumber, String newName, String newPosition, int newJerseyNumber) {
        for (Player p : team.getPlayers()) {
            if (p.getJerseyNumber() == jerseyNumber) {
                p.setName(newName);
                p.setPosition(newPosition);
                p.setJerseyNumber(newJerseyNumber);
                storage.savePlayers(team);
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
                storage.savePlayers(team);
                return true;
            }
        }
        return false;
    }
}
