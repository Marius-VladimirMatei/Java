import java.util.List;

// Calculates the frequency of each number from a list of lottery draws.

public class FrequencyCalculator {

    public int[] calculateFrequency(List<LottoDraw> draws) {
        int maxNumber = LottoDrawGenerator.MAX_NUMBER; // 45
        int[] frequency = new int[maxNumber + 1]; // index 0 is not used!!

        for (LottoDraw draw : draws) { // for each draw
            for (int num : draw.getNumbers()) { // for each number in the draw
                frequency[num]++; // increment the frequency of the number
            }
        }
        return frequency;
    }
}
