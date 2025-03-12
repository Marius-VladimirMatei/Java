import java.util.Scanner;

public class Main {

    // Method to get input from user
    public static Input getInput() {
        Scanner mathScanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double number1 = mathScanner.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        String operator = mathScanner.next();

        System.out.print("Enter the second number: ");
        double number2 = mathScanner.nextDouble();

        // Close the scanner
        mathScanner.close();

        return new Input(number1, operator, number2);
    }


    public static void main(String[] args) {
        System.out.println("Simple Calculator App");

        // Read input from the user using the Input class
        Input userInput = getInput();

        // Create a MathOperations instance using the two numbers
        Calculator newOperation = new Calculator(userInput.getNumber1(), userInput.getNumber2());

        double result = 0;

        // Determine the operation based on the operator input
        switch (userInput.getMathOperator()) {
            case "+":
                result = newOperation.add();
                System.out.println("The result is: "+ result);
                break;
            case "-":
                result = newOperation.subtract();
                System.out.println("The result is: " + result);
                break;
            case "*":
                result = newOperation.multiply();
                System.out.println("The result is: " + result);
                break;
            case "/":
                result = newOperation.divide();
                System.out.println("The result is: " + result);
                break;
            default:
                System.out.println("Invalid operator entered.");
                break;
        }

    }
}
