/*
 * Class: CMSC203 
 * Instructor:Professor Ahmed Tarek
 * Description: holiday bonus program
 * Due: 11/25/24
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Leoul Hailu Woldeyes
*/

package LeoulHailuPrj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

    // Compute the sum of all elements in the array
    public static double getTotal(double[][] array) {
        double sum = 0;
        for (double[] row : array) {
            for (double value : row) {
                sum += value;
            }
        }
        return sum;
    }

    // Calculate the sum of a specific row
    public static double getRowTotal(double[][] array, int rowIndex) {
        if (array == null || rowIndex < 0 || rowIndex >= array.length) {
            return 0; // Return 0 for invalid inputs
        }
        double rowSum = 0;
        for (double value : array[rowIndex]) {
            rowSum += value;
        }
        return rowSum;
    }

    // Compute the sum of a specific column
    public static double getColumnTotal(double[][] array, int columnIndex) {
        double columnSum = 0;
        if (array == null) {
            return 0; // Return 0 if array is null
        }
        for (double[] row : array) {
            if (columnIndex < row.length) {
                columnSum += row[columnIndex];
            }
        }
        return columnSum;
    }

    // Find the highest value in a given column
    public static double getHighestInColumn(double[][] array, int columnIndex) {
        double max = Double.NEGATIVE_INFINITY;
        boolean isValid = false;

        for (double[] row : array) {
            if (columnIndex < row.length) {
                max = Math.max(max, row[columnIndex]);
                isValid = true;
            }
        }

        return isValid ? max : 0; // Return 0 if no valid data exists
    }

    // Find the lowest value in a given column
    public static double getLowestInColumn(double[][] array, int columnIndex) {
        double min = Double.POSITIVE_INFINITY;
        boolean isValid = false;

        for (double[] row : array) {
            if (columnIndex < row.length) {
                min = Math.min(min, row[columnIndex]);
                isValid = true;
            }
        }

        return isValid ? min : 0; // Return 0 if no valid data exists
    }

    // Identify the smallest value in the entire array
    public static double getLowestInArray(double[][] array) {
        double min = Double.POSITIVE_INFINITY;
        if (array == null) {
            return 0; // Return 0 if the array is null
        }
        for (double[] row : array) {
            for (double value : row) {
                min = Math.min(min, value);
            }
        }
        return min;
    }

    // Read a 2D ragged array from a file
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(file);
        StringBuilder dataBuilder = new StringBuilder();

        while (fileScanner.hasNextLine()) {
            dataBuilder.append(fileScanner.nextLine()).append("\n");
        }

        fileScanner.close();
        String[] lines = dataBuilder.toString().split("\n");
        double[][] result = new double[lines.length][];

        for (int i = 0; i < lines.length; i++) {
            String[] tokens = lines[i].trim().split("\\s+");
            result[i] = new double[tokens.length];
            for (int j = 0; j < tokens.length; j++) {
                try {
                    result[i][j] = Double.parseDouble(tokens[j]);
                } catch (NumberFormatException e) {
                    result[i][j] = 0; // Default to 0 for invalid data
                }
            }
        }

        return result;
    }

    // Write a 2D ragged array to a file
    public static void writeToFile(double[][] array, File file) throws FileNotFoundException {
        PrintWriter fileWriter = new PrintWriter(file);

        for (double[] row : array) {
            for (double value : row) {
                fileWriter.print(value + " ");
            }
            fileWriter.println();
        }

        fileWriter.close();
    }
}
