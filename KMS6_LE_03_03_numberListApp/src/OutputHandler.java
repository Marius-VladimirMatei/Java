import java.util.List;

// Class designed to handle the output
public class OutputHandler {
    public void displayList(List<Integer> numberList) {

        System.out.println("The generated list is: ");
        // Print each number in the list
        for (int i = 0; i < numberList.size(); i++) {
            int number = numberList.get(i);
            System.out.print(number + " ");
        }
        System.out.println(); // Move to the next line after printing the list.
    }
}