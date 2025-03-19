import java.util.List;

// Class designed to handle output to the console into a table like format

public class OutputHandler {
    public void displayTable(List<Integer> priceList) {
        System.out.println("\nPrice Overview Table:");
        System.out.println("---------------------------");
        System.out.println("   Quantity | Price ");
        System.out.println("---------------------------");

        for (int i = 0; i < priceList.size(); i++) {
            int quantity = (i + 1) * 10;
            int price = priceList.get(i);
            System.out.printf("  %8d | %6d%n", quantity, price);
        }

        System.out.println("---------------------------");
    }
}
