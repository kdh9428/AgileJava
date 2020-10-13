package sis.languageTest.lesson10;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx1 {

    @Test
    public void testIOEx() {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;

        while ((data = input.read()) != -1) {
            output.write(data);
        }

        outSrc = output.toByteArray();

        System.out.println("Input Source : " + Arrays.toString(inSrc));
        System.out.println("Input Source : " + Arrays.toString(outSrc));
    }

    @Test
    public void testIOEx2() {

        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[10];

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        input.read(temp, 0, temp.length);

        output.write(temp, 5, 5);
        outSrc = output.toByteArray();

        System.out.println("Input Source : "+ Arrays.toString(inSrc));
        System.out.println("temp : "+ Arrays.toString(temp));
        System.out.println("Output Source : "+ Arrays.toString(outSrc));
    }
}
