package controllers;

import java.util.ArrayList;
import java.util.List;
import data_persistance.Storage;
import models.Team;

public class TeamManager {
    private List<Team> teams;
    private Storage storage;

    public TeamManager(Storage storage) {
        this.storage = storage;
        this.teams = storage.loadTeamsFromCSV();
        if (this.teams == null) {
            this.teams = new ArrayList<>();
        }
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void saveTeams() {
        storage.saveTeamsToCSV(teams);
    }
}