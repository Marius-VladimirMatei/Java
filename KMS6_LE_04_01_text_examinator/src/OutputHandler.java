
// Class designed to handle the output to the user.

public class OutputHandler {

    public void displayStatistics(TextStatistics statistics) {

        System.out.println("The text contains the following statistics:");
        System.out.println("Vowels:             " + statistics.getVowelCount());
        System.out.println("Consonants:         " + statistics.getConsonantCount());
        System.out.println("Digits:             " + statistics.getDigitsCount());
        System.out.println("Punctuation marks:  " + statistics.getPunctuationCount());
        System.out.println("Spaces:             " + statistics.getSpaceCount());
        System.out.println("Total length:       " + statistics.getTotalLength());
    }
}
