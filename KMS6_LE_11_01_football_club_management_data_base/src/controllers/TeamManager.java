package controllers;

import data_persistance.Storage;
import models.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamManager {
    private List<Team> teams;
    private Storage storage;

    public TeamManager(Storage storage) {
        this.storage = storage;
        this.teams = storage.loadTeams();
        if (this.teams == null) {
            this.teams = new ArrayList<>();
        }
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void saveTeams() {
        storage.saveTeams(teams);
    }
}