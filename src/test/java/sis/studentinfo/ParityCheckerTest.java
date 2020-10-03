package sis.studentinfo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParityCheckerTest {

    @Test
    public void testSingleByte(){
        ParityChecker checker = new ParityChecker();

        byte source1 = 10; // 1010
        byte source2 = 13; // 1101
        byte source3 = 2; // 0010

        byte [] data = new byte[]{source1, source2, source3};

        byte checksum = 5; //0101

        assertEquals(checksum, checker.checksum(data));

        //corrupt the source2 element
        data[1] = 14;
        assertFalse(checksum == checker.checksum(data));
        assertTrue(6 == checker.checksum(data));
    }
}
