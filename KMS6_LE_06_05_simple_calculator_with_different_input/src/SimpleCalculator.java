// Class designed for the logic of the calculator

public class SimpleCalculator implements Calculator {

    // Integer addition
    public int add(int a, int b) {
        return a + b;
    }

    // Decimal addition
    public double add(double a, double b) {
        return a + b;
    }

    // Integer subtraction
    public int subtract(int a, int b) {
        return a - b;
    }

    // Decimal subtraction
    public double subtract(double a, double b) {
        return a - b;
    }

    // Integer multiplication
    public int multiply(int a, int b) {
        return a * b;
    }

    // Decimal multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Integer division with zero-check
    public int divide(int a, int b) {
        if (b == 0) {
            System.out.println("You cannot divide by zero!");
            return 0;
        }
        return a / b;
    }

    // Decimal division with zero-check
    public double divide(double a, double b) {
        if (b == 0.0) {
            System.out.println("You cannot divide by zero!");
            return 0.0;
        }
        return a / b;
    }
}
