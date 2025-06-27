package controllers;

import java.util.List;
import models.Team;

public class TeamController {
    private List<Team> teams;
    private TeamManager teamManager;

    public TeamController(List<Team> teams, TeamManager teamManager) {
        this.teams = teams;
        this.teamManager = teamManager;
    }

    public void addTeam(Team team) {
        teams.add(team);
        teamManager.saveTeams();
        System.out.println("Team added successfully!");
    }

    public void displayTeamDetails() {
        int index = 1;
        System.out.println("\nClub Team Details (Total Teams: " + teams.size() + "):");

        if (teams.isEmpty()) {
            System.out.println("No teams in the club.");
            return;
        }

        for (Team team : teams) {
            System.out.println(index++ + " " + team.getDetails());
        }
        System.out.println();
    }
}