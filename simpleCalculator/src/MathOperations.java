public class MathOperations {

    private double number1;
    private double number2;

    public MathOperations(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public double add() {
        return number1 + number2;
    }

    public double subtract() {
        return number1 - number2;
    }

    public double multiply() {
        return number1 * number2;
    }

    public double divide() {
        if (number2 == 0) {
            System.out.println("Error: Division by 0 is not possible.");
            return 0;
        } else {
            return number1 / number2;
        }
    }
}
