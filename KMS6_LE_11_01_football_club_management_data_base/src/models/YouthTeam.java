package models;

public class YouthTeam extends Team {
    private int ageLimit;

    public YouthTeam(String name, String coach, int playerCount, int ageLimit) {
        super(name, coach, playerCount);
        this.ageLimit = ageLimit;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    @Override
    public String getDetails() {
        return "Type: Youth Team, Name: " + getName() + ", Coach: " + getCoach() +
                ", Player Count: " + getPlayerCount() + ", Age Limit: " + ageLimit;
    }
}