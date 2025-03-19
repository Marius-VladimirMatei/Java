import java.util.ArrayList;
import java.util.List;

public class IncrementalPriceGenerator {

    // Method to generate the list
    public List<Integer> generateList(int start, int end, int step) {

        List<Integer> priceList = new ArrayList<>();
        for (int i = start; i <= end; i += step) {
            priceList.add(i);
        }
        return priceList;
    }
}
