package sis.studentinfo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathTest {

    private static final double TOLERANCE = 0.05;

    @Test
    public void testHypotenuse(){

        assertEquals(5.0, Math.hypot(3.0, 4.0), TOLERANCE);
    }

    @Test
    public void testInteger(){
        assertEquals("101", Integer.toBinaryString(5));
        assertEquals("32", Integer.toHexString(50));
        assertEquals("21", Integer.toOctalString(17));

        assertEquals("1022", Integer.toString(35, 3));


        assertEquals(17, Integer.parseInt("17"));

        assertEquals(253, Integer.decode("0xFD"));
        assertEquals(253, Integer.decode("0XFD"));
        assertEquals(253, Integer.decode("#FD"));
        assertEquals(15, Integer.decode("017"));
        assertEquals(10, Integer.decode("10"));
        assertEquals(-253, Integer.decode("-0xFD"));
        assertEquals(-253, Integer.decode("-0XFD"));
        assertEquals(-253, Integer.decode("-#FD"));
        assertEquals(-15, Integer.decode("-017"));
        assertEquals(-10, Integer.decode("-10"));

    }

    @Test
    public void testCoinFlips(){
        final long seed = 100L;
        final int total = 10;
        Random random1 = new Random(seed);

        List<Boolean> flips1 = new ArrayList<>();

        for (int i = 0; i < total; i++){
            flips1.add(random1.nextBoolean());
        }

        Random random2 = new Random(seed);
        List<Boolean> flips2 = new ArrayList<>();
        for (int i = 0; i < total; i++){
            flips2.add(random2.nextBoolean());
        }

        assertEquals(flips1, flips2);
    }
}
