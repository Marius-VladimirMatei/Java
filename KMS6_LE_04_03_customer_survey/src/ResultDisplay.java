// Class designed to display the survey results

// -20s: left-justified string with a width of 20 characters
// -10d: left-justified integer with a width of 10 characters  
// -10.2f: left-justified floating-point number with a width of 10 characters and 2 decimal places

public class ResultDisplay {
        public void displayResults(SurveyResult result) {

                int totalResponses = result.getTotalResponses(); // get total responses

                System.out.println("Survey Results:");
                System.out.println("------------------------------");

                System.out.printf("%-20s %-10s %-10s%n", "Rating", "Count", "Percentage");

                System.out.printf("%-20s %-10d %-10.2f%n", Rating.NOT_RECOMMENDABLE.getDescription(),
                                result.getCountNotRecommendable(), result.getPercentageNotRecommendable());

                System.out.printf("%-20s %-10d %-10.2f%n", Rating.ACCEPTABLE.getDescription(),
                                result.getCountAcceptable(), result.getPercentageAcceptable());

                System.out.printf("%-20s %-10d %-10.2f%n", Rating.EXCELLENT.getDescription(),
                                result.getCountExcellent(), result.getPercentageExcellent());
                System.out.println("------------------------------");

                System.out.printf("Overall Rating: %.2f%n", result.getOverallRating());
        }
}
