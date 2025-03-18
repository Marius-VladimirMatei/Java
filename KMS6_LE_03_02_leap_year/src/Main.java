import java.util.List;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();

        // Using the getValidatedInteger method with custom prompts
        int startYear = input.getValidatedInteger("Enter the start year: ");
        int endYear = input.getValidatedInteger("Enter the end year: ");

        // Validate that the start year is less than or equal to the end year
        if (startYear > endYear) {
            System.out.println("Start year should be less than or equal to the end year. Exiting program.");
            return;
        }


        List<Integer> leapYears = LeapYearCalculator.listLeapYears(startYear, endYear);
        System.out.println("Leap years between " + startYear + " and " + endYear + ":");
        for (int year : leapYears) {
            System.out.println(year);
        }
    }
}