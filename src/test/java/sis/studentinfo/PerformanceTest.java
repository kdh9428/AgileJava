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

        assertTrue(Arrays.equals(a, b));
    }

    @Test
    public void testAverageForNoScores() {
        Performance performance = new Performance();
        assertEquals(0.0, performance.average());

//        assertTrue(Double.isNaN(performance.average()));

    }

    @Test
    public void testNaN() {
        double a = 0;
        int b = 0;

        System.out.println(a / b);

        assertFalse(Double.NaN > 0.0);
        assertFalse(Double.NaN < 1.0);
        assertFalse(Double.NaN == 1.0);
        assertFalse(Double.NaN == 0.0);

        assertTrue(Double.isNaN(0.0 / 0));

    }

    @Test
    public void testInfinity() {
        final float tolerance = 0.5f;
        final float x = 1f;

        assertEquals(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY * 100, 2);
        assertEquals(Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY * -1, tolerance);

        assertEquals(Float.POSITIVE_INFINITY, x / 0f, 2);
        assertEquals(Float.NEGATIVE_INFINITY, x / -0f, tolerance);
        assertTrue(Float.isNaN(x % 0f));

    }

    @Test
    public void testOverflow() {

        byte b = Byte.MAX_VALUE;
        assertEquals(Byte.MAX_VALUE + 1, b + 1);
        assertEquals(b + 1, 128);


        b += 1;
        assertEquals(Byte.MIN_VALUE, b);

        assertTrue(Double.isInfinite(Double.MAX_VALUE * Double.MAX_VALUE));
    }

    @Test
    public void testBinary() {
        assertEquals(0, 0 & 0);
        assertEquals(0, 0 & 1);
        assertEquals(0, 1 & 0);
        assertEquals(1, 1 & 1);

        assertEquals(0, 0 | 0);
        assertEquals(1, 0 | 1);
        assertEquals(1, 1 | 0);
        assertEquals(1, 1 | 1);

        assertEquals(0, 0 ^ 0);
        assertEquals(1, 0 ^ 1);
        assertEquals(1, 1 ^ 0);
        assertEquals(0, 1 ^ 1);

        int x = 0x7FFFFFF1; //0111 1111 1111 1111 1111 1111 1111 0001
        assertEquals(0x8000000E, ~x); // 1000 0000 0000 0000 0000 0000 0000 1110


    }
}
