
// Class designed for Rating logic

// enum class used for rating types - unchangeable variables, like final variable
public enum Rating {
    NOT_RECOMMENDABLE(1, "Not recommendable"),
    ACCEPTABLE(2, "Acceptable"),
    EXCELLENT(3, "Excellent");

    private int value;
    private String description;

    Rating(int value, String description) {
        this.value = value;
        this.description = description;
    }

    // Getters for rating value and description
    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    // Method to get rating by value
    public static Rating fromValue(int value) {
        // Get all values from enum by iterating through them
        Rating[] ratings = Rating.values();
        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i].getValue() == value) {
                return ratings[i];
            }
        }
        throw new IllegalArgumentException("Invalid rating value: " + value);
    }
}
