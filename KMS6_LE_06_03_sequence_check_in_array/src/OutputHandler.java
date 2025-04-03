import java.util.Arrays;

public class OutputHandler {
    public static void print(String message) {
        System.out.println(message);
    }

    public static void printArray(String label, int[] array) {
        System.out.println(label + ": " + Arrays.toString(array));
    }
}
