import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get number of test persons - user input
        System.out.print("Enter number of test persons: ");
        int numberOfTestPersons = scanner.nextInt();

        // Conduct survey
        Survey survey = new Survey();
        SurveyResult result = survey.conductSurvey(numberOfTestPersons);

        // Display survey results
        ResultDisplay display = new ResultDisplay();
        display.displayResults(result);

        scanner.close();
    }
}
