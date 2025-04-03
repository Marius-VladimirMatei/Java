public class SequenceChecker {

    // Logic for sequence checking

    // array and sequence as parameters
    // returns true if the sequence is found in the array, false otherwise
    public static boolean searchSequence(int[] array, int[] sequence) {
        if (array == null || sequence == null || sequence.length == 0 || sequence.length > array.length) {
            return false; // Invalid input check
        }
        // Iterate through the array to find the sequence
        for (int i = 0; i <= array.length - sequence.length; i++) {

            boolean match = true; // set true to boolean variable to assume a match is found (used as a flag)
            // Check if the sequence matches the array starting from index i
            for (int j = 0; j < sequence.length; j++) {
                if (array[i + j] != sequence[j]) {
                    match = false;
                    break; // break when a mismatch is found
                }
            }
            if (match) {
                return true; // return true if the sequence is found
            }
        }
        return false;
    }
}
