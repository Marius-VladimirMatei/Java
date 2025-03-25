// CLass designed for survey logic and methods
// Accumulating data, percentage calculations

public class SurveyResult {
    private int countNotRecommendable;
    private int countAcceptable;
    private int countExcellent;

    public SurveyResult() {
        this.countNotRecommendable = 0;
        this.countAcceptable = 0;
        this.countExcellent = 0;
    }

    // Method to add rating to survey using switch statement
    public void addRating(Rating rating) {
        switch (rating) {
            case NOT_RECOMMENDABLE:
                countNotRecommendable++;
                break;
            case ACCEPTABLE:
                countAcceptable++;
                break;
            case EXCELLENT:
                countExcellent++;
                break;
        }
    }

    // Getters for survey results
    public int getCountNotRecommendable() {
        return countNotRecommendable;
    }

    public int getCountAcceptable() {
        return countAcceptable;
    }

    public int getCountExcellent() {
        return countExcellent;
    }

    public int getTotalResponses() {
        return countNotRecommendable + countAcceptable + countExcellent;
    }

    // Percentage calculations
    public double getPercentageNotRecommendable() {
        if (getTotalResponses() == 0) {
            return 0;
        } else {
            return countNotRecommendable * 100.0 / getTotalResponses();
        }
    }

    public double getPercentageAcceptable() {
        if (getTotalResponses() == 0) {
            return 0;
        } else {
            return countAcceptable * 100.0 / getTotalResponses();
        }
    }

    public double getPercentageExcellent() {
        if (getPercentageAcceptable() == 0) {
            return 0;
        } else {
            return countExcellent * 100.0 / getTotalResponses();
        }
    }

    // Overall rating calculation
    public double getOverallRating() {
        int total = getTotalResponses();
        if (total == 0) {
            return 0;
        }

        return ((Rating.NOT_RECOMMENDABLE.getValue() * countNotRecommendable)
                + (Rating.ACCEPTABLE.getValue() * countAcceptable)
                + (Rating.EXCELLENT.getValue() * countExcellent))
                / (double) total;
    }

}
