package models;

public class SeniorTeam extends Team {
    private int minimumAge;

    public SeniorTeam(String name, String coach, int playerCount, int minimumAge) {
        super(name, coach, playerCount);
        this.minimumAge = minimumAge;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    @Override
    public String getDetails() {
        return "Type: Senior Team, Name: " + getName() + ", Coach: " + getCoach() +
                ", Player Count: " + getPlayerCount() + ", Minimum Age: " + minimumAge;
    }
}