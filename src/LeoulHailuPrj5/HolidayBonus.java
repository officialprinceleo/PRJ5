/*
 * Class: CMSC203 
 * Instructor: Professor Ahmed Tarek
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

public class HolidayBonus {

    private static final double HIGH_BONUS = 5000.0;
    private static final double LOW_BONUS = 1000.0;
    private static final double MID_BONUS = 3000.0;

    public static double[] calculateHolidayBonus(double[][] salesData) {
        int storeCount = salesData.length;
        double[] bonusArray = new double[storeCount];

        int maxColumns = getMaxColumns(salesData);

        for (int col = 0; col < maxColumns; col++) {
            double highestValue = Double.NEGATIVE_INFINITY;
            double lowestValue = Double.POSITIVE_INFINITY;

            // Find highest and lowest values in the column
            for (int row = 0; row < storeCount; row++) {
                if (col < salesData[row].length) {
                    double value = salesData[row][col];
                    if (value > highestValue) {
                        highestValue = value;
                    }
                    if (value < lowestValue) {
                        lowestValue = value;
                    }
                }
            }

            // Assign bonuses to each store based on their sales
            for (int row = 0; row < storeCount; row++) {
                if (col < salesData[row].length) {
                    double value = salesData[row][col];
                    if (value == highestValue) {
                        bonusArray[row] += HIGH_BONUS;
                    } else if (value == lowestValue) {
                        bonusArray[row] += LOW_BONUS;
                    } else {
                        bonusArray[row] += MID_BONUS;
                    }
                }
            }
        }

        return bonusArray;
    }

    public static double calculateTotalHolidayBonus(double[][] salesData) {
        double totalBonus = 0.0;
        double[] bonuses = calculateHolidayBonus(salesData);

        for (double bonus : bonuses) {
            totalBonus += bonus;
        }

        return totalBonus;
    }

    private static int getMaxColumns(double[][] salesData) {
        int maxCols = 0;
        for (double[] row : salesData) {
            if (row.length > maxCols) {
                maxCols = row.length;
            }
        }
        return maxCols;
    }
}
