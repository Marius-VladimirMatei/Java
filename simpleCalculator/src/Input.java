import java.util.Scanner;

public class Input {
    private double number1;
    private double number2;
    private String math_operation;

    // Constructor
    public Input(double number1, String operator, double number2) {
        this.number1 = number1;
        this.math_operation = operator;
        this.number2 = number2;
    }

    // Getters for the input fields
    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }

    public String getMath_operation() {
        return math_operation;
    }

    // Static method to read input from the user and return an Input object
    public static Input getInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double number1 = scanner.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        String operator = scanner.next();

        System.out.print("Enter the second number: ");
        double number2 = scanner.nextDouble();

        return new Input(number1, operator, number2);
    }
}
