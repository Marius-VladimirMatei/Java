// Class designed for the logic of addition



public class Calculator {

    public double sum(double[] numbers) {
        double total = 0;

        // Loop through each element in the array and add it to the total.
        for (int i = 0; i < numbers.length; i++) {
            total = total + numbers[i];
        }

        return total;
    }
}
