package sis.studentinfo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTest {


    class MockRandom extends Random {
        private int i;

        MockRandom(char startCharValue) {
            i = startCharValue - PasswordGenerator.LOW_END_PASSWORD_CHAR;
        }

        protected int next(int bits) {
            return i++;
        }
    }

    @Test
    public void testGeneratePassword() {

        PasswordGenerator generator = new PasswordGenerator();
        generator.setRandom(new MockRandom('A'));

        assertEquals("ABCDEFGH", generator.generatePassword());

//        generator.setRandom(new MockRandom('C'));
//        assertEquals("CDEFGHIJ", generator.generatePassword());

    }

    @Test
    public void testBigDecimalImmutable() {
        BigDecimal bigDecimal = new BigDecimal("123.15");

        BigDecimal add = bigDecimal.add(new BigDecimal("2"));

        int value = add.intValue();

        assertEquals(value, 125);
        assertEquals(bigDecimal.doubleValue(), 123.15);
    }

    @Test
    public void testBigDecimalMulti() {
        BigDecimal decimal = new BigDecimal("10.00");
        BigDecimal decimal1 = new BigDecimal("1");

        BigDecimal multiply = decimal1.multiply(new BigDecimal("10.00"));

        assertFalse(decimal.equals(decimal1));
        assertTrue(decimal.equals(multiply));

    }

    @Test
    public void CompilerError() {
        float x = 0.01F;

        int rint = (int) Math.rint(1.9);
        System.out.println(rint);

        double rint1 = Math.rint(1.5);
        assertEquals(rint1, 2.0);
        double rint2 = Math.rint(2.5);
        assertEquals(rint2, 2.0);

        double rint3 = Math.rint(3.5);
        assertEquals(rint3, 4.0);

        double rint4 = Math.rint(4.5);
        assertEquals(rint4, 4.0);

    }

    @Test
    public void testCalculator() {
        int x = 0;
        int y = 0;

        int z = x * 5 + y++ * 7 / 4;
        System.out.println(z);
        z = ++x * 5 * y++;
        System.out.println(z);
        z = x++ * 5 * ++y;

    }

}