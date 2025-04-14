// Class designed to sort lottery numbers in ascending order

import java.util.Arrays;

public class LotteryNumberSorter {
    // Sort the numbers in ascending order
    public int[] sortNumbers(int[] numbers) {
        int[] sortedNumbers = numbers.clone(); // Create a copy to avoid modifying the original
        Arrays.sort(sortedNumbers);
        return sortedNumbers;
    }
}