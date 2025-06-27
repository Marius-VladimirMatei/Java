package models;

import java.util.ArrayList;
import java.util.List;

public abstract class Team {
    private String name;
    private String coach;
    private int playerCount;
    private List<Player> players;

    public Team(String name, String coach, int playerCount) {
        this.name = name;
        this.coach = coach;
        this.playerCount = playerCount;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCoach() {
        return coach;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public abstract String getDetails();
}