package data_persistance;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import models.Player;
import models.SeniorTeam;
import models.Team;
import models.YouthTeam;

public class Storage {
    private static final String CSV_FILE = "teams.csv";

    public void saveTeamsToCSV(List<Team> teams) {
        try (FileWriter writer = new FileWriter(CSV_FILE)) {
            writer.write("type, name, coach, playerCount, specificAttribute\n");
            for (Team team : teams) {
                StringBuilder line = new StringBuilder();
                if (team instanceof YouthTeam) {
                    YouthTeam youthTeam = (YouthTeam) team;
                    line.append("YouthTeam, ")
                            .append(youthTeam.getName()).append(",")
                            .append(youthTeam.getCoach()).append(",")
                            .append(youthTeam.getPlayerCount()).append(",")
                            .append(youthTeam.getAgeLimit());
                } else if (team instanceof SeniorTeam) {
                    SeniorTeam seniorTeam = (SeniorTeam) team;
                    line.append("SeniorTeam, ")
                            .append(seniorTeam.getName()).append(",")
                            .append(seniorTeam.getCoach()).append(",")
                            .append(seniorTeam.getPlayerCount()).append(",")
                            .append(seniorTeam.getMinimumAge());
                }
                writer.write(line.toString() + "\n");
            }
            System.out.println("Teams saved to " + CSV_FILE);
        } catch (IOException e) {
            System.out.println("Error saving teams to CSV: " + e.getMessage());
        }
    }

    public List<Team> loadTeamsFromCSV() {
        List<Team> teams = new ArrayList<>();
        File file = new File(CSV_FILE);
        if (!file.exists()) {
            return teams;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String type = data[0];
                String name = data[1];
                String coach = data[2];
                int playerCount = Integer.parseInt(data[3]);
                int specificAttribute = Integer.parseInt(data[4]);

                Team team;
                switch (type) {
                    case "YouthTeam":
                        team = new YouthTeam(name, coach, playerCount, specificAttribute);
                        break;
                    case "SeniorTeam":
                        team = new SeniorTeam(name, coach, playerCount, specificAttribute);
                        break;
                    default:
                        continue;
                }
                // Load players for this team
                team.getPlayers().addAll(loadPlayersFromCSV(team));
                teams.add(team);
            }
            System.out.println("Teams loaded from " + CSV_FILE);
        } catch (IOException e) {
            System.out.println("Error loading teams from CSV: " + e.getMessage());
        }
        return teams;
    }

    public void savePlayersToCSV(Team team) {
        String playerFileName = team.getName().replaceAll(" ", "") + "_players.csv";
        try (FileWriter writer = new FileWriter(playerFileName)) {
            writer.write("name,position,jerseyNumber\n");
            for (Player player : team.getPlayers()) {
                String line = player.getName() + "," + player.getPosition() + "," + player.getJerseyNumber();
                writer.write(line + "\n");
            }
            System.out.println("Players for " + team.getName() + " saved to " + playerFileName);
        } catch (IOException e) {
            System.out.println("Error saving players to CSV: " + e.getMessage());
        }
    }

    public List<Player> loadPlayersFromCSV(Team team) {
        List<Player> players = new ArrayList<>();
        String playerFileName = team.getName().replaceAll(" ", "") + "_players.csv";
        File file = new File(playerFileName);
        if (!file.exists()) {
            return players;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(playerFileName))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String position = data[1];
                int jerseyNumber = Integer.parseInt(data[2]);
                players.add(new Player(name, position, jerseyNumber));
            }
            System.out.println("Players for " + team.getName() + " loaded from " + playerFileName);
        } catch (IOException e) {
            System.out.println("Error loading players from CSV: " + e.getMessage());
        }
        return players;
    }
}