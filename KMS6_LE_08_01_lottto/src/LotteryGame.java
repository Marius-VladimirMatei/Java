// Class designed to run the lottery game

public class LotteryGame {
    private static final int NUMBER_COUNT = 6;
    private LotteryInputHandler inputHandler;
    private LotteryNumberValidator validator;
    private LotteryNumberSorter sorter;

    public LotteryGame() {
        this.inputHandler = new LotteryInputHandler();
        this.validator = new LotteryNumberValidator();
        this.sorter = new LotteryNumberSorter();
    }

    // Run the lottery game and return the sorted numbers
    public int[] play() {
        int[] numbers = new int[NUMBER_COUNT];

        // Get 6 valid numbers from the user
        for (int i = 0; i < NUMBER_COUNT; i++) {
            int number;
            do {
                number = inputHandler.getNumber(i + 1);
            } while (!validator.isValid(number)); // Keep asking until a valid number is entered
            numbers[i] = number;
        }

        // Sort the numbers and return them
        return sorter.sortNumbers(numbers);
    }
}