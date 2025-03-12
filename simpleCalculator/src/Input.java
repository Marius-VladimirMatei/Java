public class Input {
    private double number1;
    private double number2;
    private String mathOperator;

    // Constructor
    public Input(double number1, String mathOperator, double number2) {
        this.number1 = number1;
        this.mathOperator = mathOperator;
        this.number2 = number2;
    }

    // Getters for the input fields
    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }

    public String getMathOperator() {
        return mathOperator;
    }

}
