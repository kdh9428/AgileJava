package sis.studentinfo;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PerformanceTest {

    private static final double tolerance = 0.005;

    @Test
    public void testAverage() {
        Performance performance = new Performance();
        performance.setNumberOfTests(4);
        performance.set(0, 98);
        performance.set(1, 92);
        performance.set(2, 81);
        performance.set(3, 72);

        assertEquals(92, performance.get(1));
        assertEquals(85.75, performance.average(), tolerance);

        performance.setScores(new int[]{75, 72, 90, 60});

        assertEquals(74.25, performance.average(), tolerance);

        performance.setScores(100, 90);
        assertEquals(95.0, performance.average(), tolerance);


    }

    @Test
    public void testInitialization() {
        Performance performance = new Performance();
        performance.setScores(75, 72, 90, 60);
        assertEquals(74.25, performance.average(), tolerance);
    }

    @Test
    public void testTwoDimensionalArrays() {
        final int rows = 3;
        final int cols = 4;

        int count = 0;

        int[][] matrix = new int[rows][cols];

        for (int x = 0; x < rows; x++)
            for (int y = 0; y < cols; y++) {
                matrix[x][y] = count++;
            }
        assertEquals(11, matrix[2][3]);
        assertEquals(6, matrix[1][2]);
    }

    @Test
    public void testPartialDimensions() {
        final int rows = 3;
        int[][] matrix = new int[rows][];

        matrix[0] = new int[]{0};
        matrix[1] = new int[]{1, 2};
        matrix[2] = new int[]{3, 4, 5};

        assertEquals(1, matrix[1][0]);
        assertEquals(5, matrix[2][2]);

        for (int[] ma : matrix) {
            for (int ss : ma) {
                System.out.print(ss);
            }
            System.out.println();
        }
        int[][] matrix2 = {{0}, {1, 2}, {3, 4, 5}};

        for (int[] arrays : matrix2) {
            for (int a : arrays) {
                System.out.print(a);
            }
            System.out.println();
        }

        int a = matrix2.length;
        System.out.println("길이 :" + a);

    }

    @Test
    public void testArrayEquality() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};

        assertFalse(a == b);
    }

    @Test
    public void testArrayEquals() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};

        assertTrue(Arrays.equals(a,b));
    }

}