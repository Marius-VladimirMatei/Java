package data_persistance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Player;
import models.Team;
import models.YouthTeam;
import models.SeniorTeam;

/**
 * Storage handles all load/save operations against MySQL.
 * We keep the same method names so TeamManager and PlayerManager
 * don't have to change much.
 */
public class Storage {

    /**
     * Loads all teams (and their players) from the DB.
     */
    public List<Team> loadTeams() {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT id, type, name, coach, player_count, specific_attribute FROM teams";

        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int teamId = rs.getInt("id");
                String type = rs.getString("type");
                String name = rs.getString("name");
                String coach = rs.getString("coach");
                int count = rs.getInt("player_count");
                int attr = rs.getInt("specific_attribute");

                Team team;
                if ("YouthTeam".equals(type)) {
                    team = new YouthTeam(name, coach, count, attr);
                } else {
                    team = new SeniorTeam(name, coach, count, attr);
                }
                // populate players for this team
                loadPlayers(team, conn, teamId);
                teams.add(team);
            }
            System.out.println("✅ Loaded teams and players from database");
        } catch (SQLException e) {
            System.err.println("Error loading teams: " + e.getMessage());
        }
        return teams;
    }

    /**
     * Saves all teams and (recursively) their players in one transaction.
     * We DELETE existing rows then INSERT fresh ones to keep it simple.
     */
    public void saveTeams(List<Team> teams) {
        String deleteTeams = "DELETE FROM teams";
        String insertTeam = "INSERT INTO teams (type, name, coach, player_count, specific_attribute) VALUES (?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                PreparedStatement ps = conn.prepareStatement(insertTeam, Statement.RETURN_GENERATED_KEYS)) {

            conn.setAutoCommit(false);

            // wipe old teams & players (players cascade on delete)
            stmt.executeUpdate(deleteTeams);

            // insert each team
            for (Team t : teams) {
                ps.setString(1, t instanceof YouthTeam ? "YouthTeam" : "SeniorTeam");
                ps.setString(2, t.getName());
                ps.setString(3, t.getCoach());
                ps.setInt(4, t.getPlayerCount());
                int spec = (t instanceof YouthTeam)
                        ? ((YouthTeam) t).getAgeLimit()
                        : ((SeniorTeam) t).getMinimumAge();
                ps.setInt(5, spec);
                ps.executeUpdate();

                // get the generated team_id
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) {
                        int teamId = keys.getInt(1);
                        savePlayersInternal(t, conn, teamId);
                    }
                }
            }
            conn.commit();
            System.out.println("✅ Saved teams and players to database");
        } catch (SQLException e) {
            System.err.println("Error saving teams: " + e.getMessage());
        }
    }

    /**
     * Public method called by PlayerManager after any single-team change.
     * Finds the team ID, then re-saves only *that* team's players.
     */
    public void savePlayers(Team team) {
        String findId = "SELECT id FROM teams WHERE name = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement psFind = conn.prepareStatement(findId)) {

            psFind.setString(1, team.getName());
            try (ResultSet rs = psFind.executeQuery()) {
                if (rs.next()) {
                    int teamId = rs.getInt("id");
                    conn.setAutoCommit(false);
                    // delete old players for this team
                    try (PreparedStatement del = conn.prepareStatement(
                            "DELETE FROM players WHERE team_id = ?")) {
                        del.setInt(1, teamId);
                        del.executeUpdate();
                    }
                    // re-insert current roster
                    savePlayersInternal(team, conn, teamId);
                    conn.commit();
                    System.out.println("✅ Saved players for team " + team.getName());
                } else {
                    System.err.println("Team not found in DB: " + team.getName());
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saving players: " + e.getMessage());
        }
    }

    // --- PRIVATE HELPERS ---

    /** Inserts all players of a given team_id; internal Transaction boundary. */
    private void savePlayersInternal(Team team, Connection conn, int teamId) throws SQLException {
        String insertPl = "INSERT INTO players (team_id, name, position, jersey_number) VALUES (?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(insertPl)) {
            for (Player p : team.getPlayers()) {
                ps.setInt(1, teamId);
                ps.setString(2, p.getName());
                ps.setString(3, p.getPosition());
                ps.setInt(4, p.getJerseyNumber());
                ps.executeUpdate();
            }
        }
    }

    /** Loads all players for a given team_id into the team's list. */
    private void loadPlayers(Team team, Connection conn, int teamId) throws SQLException {
        String sql = "SELECT name, position, jersey_number FROM players WHERE team_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, teamId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    team.getPlayers().add(
                            new Player(
                                    rs.getString("name"),
                                    rs.getString("position"),
                                    rs.getInt("jersey_number")));
                }
            }
        }
    }
}
