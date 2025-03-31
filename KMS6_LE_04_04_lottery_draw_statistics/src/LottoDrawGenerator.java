import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Class designed for generating lottery draws with unique numbers (1-6)

public class LottoDrawGenerator {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUMBERS_PER_DRAW = 6;

    // Random number generator
    private final Random random;

    public LottoDrawGenerator() {
        random = new Random();
    }

    // Generates a single LottoDraw with NUMBERS_PER_DRAW unique numbers.

    public LottoDraw generateDraw() {
        List<Integer> drawNumbers = new ArrayList<>(); // List to store the generated numbers
        while (drawNumbers.size() < NUMBERS_PER_DRAW) {
            int num = random.nextInt(MAX_NUMBER) + MIN_NUMBER; // generates a number between 1 and 45
            if (!drawNumbers.contains(num)) { // checks if the number is already in the list
                drawNumbers.add(num);
            }
        }
        return new LottoDraw(drawNumbers);
    }

    // Generates a list of LottoDraw objects.
    public List<LottoDraw> generateDraws(int numberOfDraws) {
        List<LottoDraw> draws = new ArrayList<>();
        for (int i = 0; i < numberOfDraws; i++) {
            draws.add(generateDraw());
        }
        return draws;
    }
}
