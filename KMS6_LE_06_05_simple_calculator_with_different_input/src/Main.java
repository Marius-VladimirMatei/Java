public class Main {
    public static void main(String[] args) {
        // Create instances of InputHandler, OutputHandler, and Calculator
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        Calculator calculator = new SimpleCalculator();

        while (true) {
            // Get and validate the first number
            String firstInput = inputHandler.getInput("Enter the first number (or type 'exit' to quit):");
            if (firstInput.equalsIgnoreCase("exit")) {
                break;
            }

            boolean isFirstInteger = inputHandler.isInteger(firstInput);
            boolean isFirstDouble = inputHandler.isDouble(firstInput);

            // Input validation using !(is not) logical operator
            if (!isFirstInteger && !isFirstDouble) {
                outputHandler.printError("Invalid input for the first number. Please enter a valid number.");
                continue;
            }

            // Get and validate the second number
            String secondInput = inputHandler.getInput("Enter the second number (or type 'exit' to quit):");
            if (secondInput.equalsIgnoreCase("exit")) {
                break;
            }

            boolean isSecondInteger = inputHandler.isInteger(secondInput);
            boolean isSecondDouble = inputHandler.isDouble(secondInput);

            if (!isSecondInteger && !isSecondDouble) {
                outputHandler.printError("Invalid input for the second number. Please enter a valid number.");
                continue;
            }

            // Determine if the calculation is integer-based or double-based
            boolean isIntegerCalculation = isFirstInteger && isSecondInteger;

            // Get the operation
            String operation = inputHandler.getInput("Choose operation (+, -, *, /) (or type 'exit' to quit):");
            if (operation.equalsIgnoreCase("exit")) {
                break;
            }

            // Perform the calculation
            if (isIntegerCalculation) {
                int num1 = Integer.parseInt(firstInput);
                int num2 = Integer.parseInt(secondInput);
                int result;

                switch (operation) {
                    case "+":
                        result = calculator.add(num1, num2);
                        break;
                    case "-":
                        result = calculator.subtract(num1, num2);
                        break;
                    case "*":
                        result = calculator.multiply(num1, num2);
                        break;
                    case "/":
                        result = calculator.divide(num1, num2);
                        break;
                    default:
                        outputHandler.printError("Invalid operation selected.");
                        continue;
                }

                outputHandler.printResult("Result: " + result);
            } else {
                double num1 = Double.parseDouble(firstInput);
                double num2 = Double.parseDouble(secondInput);
                double result;

                switch (operation) {
                    case "+":
                        result = calculator.add(num1, num2);
                        break;
                    case "-":
                        result = calculator.subtract(num1, num2);
                        break;
                    case "*":
                        result = calculator.multiply(num1, num2);
                        break;
                    case "/":
                        result = calculator.divide(num1, num2);
                        break;
                    default:
                        outputHandler.printError("Invalid operation selected.");
                        continue;
                }

                outputHandler.printResult("Result: " + result);
            }
        }

        inputHandler.close();
        outputHandler.printMessage("Program exited. Goodbye!");
    }
}