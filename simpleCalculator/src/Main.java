public class Main {
    public static void main(String[] args) {
        System.out.println("Simple Calculator App");

        // Read input from the user using the Input class
        Input userInput = Input.getInput();

        // Create a MathOperations instance using the two numbers
        MathOperations newOperation = new MathOperations(userInput.getNumber1(), userInput.getNumber2());

        double result = 0;

        // Determine the operation based on the operator input
        switch (userInput.getMath_operation()) {
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
