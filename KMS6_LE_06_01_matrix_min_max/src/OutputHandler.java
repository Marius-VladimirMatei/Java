public class OutputHandler {

    // Class designed to output the matrix in the form of a table

    public void printMatrix(double[][] matrix) {
        System.out.println("\nMatrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%10.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }


    // Method to print the statistics
    public void printStatistics(double min, double max) {
        System.out.println("\nMinimum value in the matrix: " + min);
        System.out.println("Maximum value in the matrix: " + max);
    }
}
