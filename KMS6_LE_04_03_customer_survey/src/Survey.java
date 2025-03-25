import java.util.Random;

// Survey class designed to generate the survey

public class Survey {
    private final Random random;

    public Survey() {
        this.random = new Random();
    }

    public SurveyResult conductSurvey(int numberOfTestPersons) {
        // store the ratings
        SurveyResult result = new SurveyResult();

        // looping through each test person
        for (int i = 0; i < numberOfTestPersons; i++) {

            // Generate a random rating between 1 and 3 ( starting at 0 up top 2 => "+1")
            int ratingValue = random.nextInt(3) + 1;
            // converting the random number to its corresponding rating
            Rating rating = Rating.fromValue(ratingValue);
            result.addRating(rating);
        }
        return result;
    }
}
