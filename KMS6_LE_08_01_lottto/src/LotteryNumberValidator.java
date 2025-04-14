// Class designed to vailidate lottery numbers
// HashSet is used to check for duplicates

import java.util.HashSet;
import java.util.Set;

public class LotteryNumberValidator {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private Set<Integer> usedNumbers;

    public LotteryNumberValidator() {
        this.usedNumbers = new HashSet<>();
    }

    // Check if the number is valid (in range and not a duplicate)
    public boolean isValid(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            System.out.println("Number must be between 1 and 45. Try again!");
            return false;
        }
        if (usedNumbers.contains(number)) {
            System.out.println("Duplicate number! Please enter a different number.");
            return false;
        }
        usedNumbers.add(number);
        return true;
    }
}

/*
 * // Old method for checking duplicates
 * 
 * // Check for duplicates by iterating through the array
 * for (int i = 0; i < currentIndex; i++) {
 * if (usedNumbers[i] == number) {
 * System.out.println("Duplicate number! Please enter a different number.");
 * return false;
 * }
 * }
 */