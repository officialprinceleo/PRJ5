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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent {

    @Test
    public void testGetTotal() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(21.0, TwoDimRaggedArrayUtility.getTotal(data), 0.001);
    }

    @Test
    public void testGetRowTotal() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(data, 0), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(data, 1), 0.001);
        assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(data, 2), 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(data, 0), 0.001);
        assertEquals(7.0, TwoDimRaggedArrayUtility.getColumnTotal(data, 1), 0.001);
        assertEquals(3.0, TwoDimRaggedArrayUtility.getColumnTotal(data, 2), 0.001);
    }

    @Test
    public void testGetHighestInColumn() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInColumn(data, 0), 0.001);
        assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInColumn(data, 1), 0.001);
        assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInColumn(data, 2), 0.001);
    }

    @Test
    public void testGetLowestInColumn() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(data, 0), 0.001);
        assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(data, 1), 0.001);
        assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInColumn(data, 2), 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(data), 0.001);
    }

    @Test
    public void testReadWriteFile() throws FileNotFoundException {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };

        File tempFile = new File("testFile.txt");
        TwoDimRaggedArrayUtility.writeToFile(data, tempFile);

        double[][] readData = TwoDimRaggedArrayUtility.readFile(tempFile);

        assertArrayEquals(data[0], readData[0], 0.001);
        assertArrayEquals(data[1], readData[1], 0.001);
        assertArrayEquals(data[2], readData[2], 0.001);

        tempFile.delete(); // Clean up
    }
}
