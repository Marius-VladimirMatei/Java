import java.util.ArrayList;
import java.util.List;


// Class to determine leap year




public class LeapYearCalculator {

    public static boolean isLeapYear(int year) {
        // Year - multiple of 4 and NOT multiple of 100;
        //		- multiple of 400;
        //		- Not every four years is a leap year. As a rule, leap years are skipped
        // if the year is divisible by 100 AND NOT by 400

        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    public static List<Integer> listLeapYears (int startYear, int endYear) {
        List<Integer> leapYearslist = new ArrayList<Integer>();
            for(int i = startYear; i <= endYear; i ++){
                if (isLeapYear(i)) {
                    leapYearslist.add(i);
                }
            }

        return leapYearslist;
    }
}
