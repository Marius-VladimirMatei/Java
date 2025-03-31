import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of lottery draws: ");
        int numberOfDraws = scanner.nextInt();

        // Generate lottery draws using the LottoDrawGenerator
        LottoDrawGenerator generator = new LottoDrawGenerator();
        List<LottoDraw> draws = generator.generateDraws(numberOfDraws);

        // Calculate frequency of each number from all draws
        FrequencyCalculator calculator = new FrequencyCalculator();
        int[] frequency = calculator.calculateFrequency(draws);

        // Print frequency and percentage for each number
        int totalNumbersDrawn = numberOfDraws * LottoDrawGenerator.NUMBERS_PER_DRAW;
        FrequencyPrinter printer = new FrequencyPrinter();
        printer.printFrequency(frequency, totalNumbersDrawn);

        scanner.close();
    }
}
