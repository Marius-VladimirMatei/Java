// Class designed to run the application.

public class AnalyzerMain {
    public static void main(String[] args) {
        // Instantiate the classes to handle the input, analyze the text and output the results.
        TextAnalyzer analyzer = new TextAnalyzer();
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        String inputText = inputHandler.getUserInput();
        TextStatistics stats = analyzer.analyzeText(inputText);

        outputHandler.displayStatistics(stats);
    }
}
