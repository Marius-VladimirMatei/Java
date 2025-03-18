import java.util.ArrayList;
import java.util.List;

// Class designed to generate a list of numbers based on start and end values
public class NumberListGenerator {

    public List<Integer> generateList(int start, int end, int step) {
        if (step <= 0) {
            throw new IllegalArgumentException("Step must be greater than 0");
        }

        List<Integer> numberList = new ArrayList<>();
        for (int i = start; i <= end; i += step) {
            numberList.add(i);
        }
        return numberList;
    }
}