import java.util.Random;

// Class designed to generate random array with size, min and max parameters

public class RandomArrayGenerator {

    public static int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt((max - min) + 1) + min;
        }
        return array;
    }
}
