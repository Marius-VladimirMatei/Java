
// Responsible for printing the frequency and percentage of each lottery number.

public class FrequencyPrinter {

    public void printFrequency(int[] frequency, int totalNumbersDrawn) { // frequency of each number and total numbers
                                                                         // drawn
        System.out.println("\nFrequency of drawn numbers (1 - " + (frequency.length - 1) + "):");
        for (int i = 1; i < frequency.length; i++) {
            double percentage = (totalNumbersDrawn > 0) ? (frequency[i] * 100.0 / totalNumbersDrawn) : 0.0;

            /*
             * double percentage;
             * if (totalNumbersDrawn > 0) {
             * percentage = frequency[i] * 100.0 / totalNumbersDrawn;
             * } else {
             * percentage = 0.0;
             * }
             */

            System.out.printf("Number %2d: %3d times (%.2f%%)%n", i, frequency[i], percentage);
        }
    }
}
/*  */