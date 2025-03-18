import java.util.List;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();

        // Using the getValidatedInteger method with custom prompts
        int startYear = input.getValidatedInteger("Enter the start year: ");
        int endYear = input.getValidatedInteger("Enter the end year: ");

        // Validate that the start year is less than the end year
        if (startYear > endYear) {
            int temp = startYear;
            startYear = endYear;
            endYear = temp;
            System.out.println("Swapping start year and end year to ensure start is less than end.");
        }

        // Output the list
        List<Integer> leapYears = LeapYearCalculator.listLeapYears(startYear, endYear);
        System.out.println("Leap years between " + startYear + " and " + endYear + ":");
        for (int year : leapYears) {
            System.out.println(year);
        }
    }
}