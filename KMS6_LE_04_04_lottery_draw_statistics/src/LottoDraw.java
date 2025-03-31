import java.util.ArrayList;
import java.util.Collections; // needed for sorting the numbers
import java.util.List;

// Represents a single lottery draw containing a set of unique numbers.

public class LottoDraw {
    private final List<Integer> numbers; // List to store the numbers

    public LottoDraw(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers); // Sort the numbers in ascending order
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
