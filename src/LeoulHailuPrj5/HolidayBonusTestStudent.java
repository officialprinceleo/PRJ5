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

import static org.junit.Assert.*;
import org.junit.Test;

public class HolidayBonusTestStudent {

    @Test
    public void testCalculateHolidayBonus() {
        double[][] salesData = {
            {2000, 4000, 6000},
            {5000, 3000, 7000},
            {1000, 8000, 9000}
        };

        double[] expectedBonuses = {9000.0, 11000.0, 15000.0};
        double[] calculatedBonuses = HolidayBonus.calculateHolidayBonus(salesData);

        assertArrayEquals("Bonuses calculated incorrectly", expectedBonuses, calculatedBonuses, 0.01);
    }

    @Test
    public void testCalculateHolidayBonusWithUnevenRows() {
        double[][] salesData = {
            {7000, 10000},
            {5000},
            {3000, 2000, 4000}
        };

        double[] expectedBonuses = {10000.0, 5000.0, 6000.0};
        double[] calculatedBonuses = HolidayBonus.calculateHolidayBonus(salesData);

        assertArrayEquals("Bonuses calcula ted incorrectly for uneven rows", expectedBonuses, calculatedBonuses, 0.01);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double[][] salesData = {
            {2000, 4000, 6000},
            {5000, 3000, 7000},
            {1000, 8000, 9000}
        };

        double expectedTotalBonus = 35000.0;
        double calculatedTotalBonus = HolidayBonus.calculateTotalHolidayBonus(salesData);

        assertEquals("Total bonus calculated incorrectly", expectedTotalBonus, calculatedTotalBonus, 0.01);
    }

    @Test
    public void testCalculateTotalHolidayBonusWithUnevenRows() {
        double[][] salesData = {
            {7000, 10000},
            {5000},
            {3000, 2000, 4000}
        };

        double expectedTotalBonus = 21000.0;
        double calculatedTotalBonus = HolidayBonus.calculateTotalHolidayBonus(salesData);

        assertEquals("Total bonus calculated incorrectly for uneven rows", expectedTotalBonus, calculatedTotalBonus, 0.01);
    }

    @Test
    public void testCalculateHolidayBonusWithZeroValues() {
        double[][] salesData = {
            {0, 0, 0},
            {0, 0},
            {0}
        };

        double[] expectedBonuses = {3000.0, 2000.0, 1000.0};
        double[] calculatedBonuses = HolidayBonus.calculateHolidayBonus(salesData);

        assertArrayEquals("Bonuses calculated incorrectly for zero values", expectedBonuses, calculatedBonuses, 0.01);
    }

    @Test
    public void testCalculateTotalHolidayBonusWithZeroValues() {
        double[][] salesData = {
            {0, 0, 0},
            {0, 0},
            {0}
        };

        double expectedTotalBonus = 6000.0;
        double calculatedTotalBonus = HolidayBonus.calculateTotalHolidayBonus(salesData);

        assertEquals("Total bonus calculated incorrectly for zero values", expectedTotalBonus, calculatedTotalBonus, 0.01);
    }
}
