// Class designed to implement the statitics logic and methods to analyze the text.

public class TextAnalyzer {

    public TextStatistics analyzeText(String text) {
        if (text == null) {
            // If the text is null return empty statistics.
            return new TextStatistics(0, 0, 0, 0, 0, 0);
        }

        // Convert the text to lower case to simplify the analysis.
        text = text.toLowerCase();

        // Initialize the counters.
        int vowelCount = 0;
        int consonantCount = 0;
        int digitsCount = 0;
        int punctuationCount = 0;
        int spaceCount = 0;
        int totalLength = text.length();

        for (int i = 0; i < text.length(); i++) {
            // Retrieves each character at the index i (basically all from the text) and
            // stores it in the variable c.
            char character = text.charAt(i);

            // Check if the character is a vowel and increment the vowel counter.
            if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
                vowelCount++;

                // Check if the character is a consonant and increment the consonant counter.
            } else if (character >= 'a' && character <= 'z') {
                consonantCount++;

                // Check if the character is a digit and increment the digit counter.
            } else if (character >= '0' && character <= '9') {
                digitsCount++;

                // Check if the character is a punctuation mark and increment the punctuation
                // counter.
            } else if (character == '.' || character == ',' || character == '!' || character == '?'
                    || character == ';') {
                punctuationCount++;

                // Check if the character is a space and increment the space counter.
            } else if (character == ' ') {
                spaceCount++;
            }
        }

        return new TextStatistics(vowelCount, consonantCount, digitsCount, punctuationCount, spaceCount, totalLength);

    }

}
