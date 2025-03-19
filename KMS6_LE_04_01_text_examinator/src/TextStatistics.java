// Class designed for counters: vowels, consonants, digits, punctuation, whitespace, total length.

public class TextStatistics {

    private int vowelCount;
    private int consonantCount;
    private int digitsCount;
    private int punctuationCount;
    private int spaceCount;
    private int totalLength;

    public TextStatistics(int vowelCount, int consonantCount, int digitsCount, int punctuationCount, int spaceCount,
            int totalLength) {
        this.vowelCount = vowelCount;
        this.consonantCount = consonantCount;
        this.digitsCount = digitsCount;
        this.punctuationCount = punctuationCount;
        this.spaceCount = spaceCount;
        this.totalLength = totalLength;
    }

    public int getVowelCount() {
        return vowelCount;
    }

    public int getConsonantCount() {
        return consonantCount;
    }

    public int getDigitsCount() {
        return digitsCount;
    }

    public int getPunctuationCount() {
        return punctuationCount;
    }

    public int getSpaceCount() {
        return spaceCount;
    }

    public int getTotalLength() {
        return totalLength;
    }

}
