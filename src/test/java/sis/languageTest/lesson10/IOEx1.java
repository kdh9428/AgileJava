package sis.languageTest.lesson10;

import org.junit.jupiter.api.Test;

import java.io.*;
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

        System.out.println("Input Source : " + Arrays.toString(inSrc));
        System.out.println("temp : " + Arrays.toString(temp));
        System.out.println("Output Source : " + Arrays.toString(outSrc));
    }

    @Test
    public void testIOEx3() {

        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.out.println("Input Source : " + Arrays.toString(inSrc));

        try {
            while (input.available() > 0) {
                int len = input.read(temp);
                output.write(temp, 0, len);

                outSrc = output.toByteArray();
                printArrays(temp, outSrc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printArrays(byte[] temp, byte[] outSrc) {
        System.out.println("temp : " + Arrays.toString(temp));
        System.out.println("Output Source : " + Arrays.toString(outSrc));
    }

    @Test
    public void testDataOutputStreamEx1() throws FileNotFoundException {
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            fos = new FileOutputStream("sample.txt");
            dos = new DataOutputStream(fos);

            dos.writeInt(10);
            dos.writeFloat(20.0f);
            dos.writeUTF("test");
            dos.writeBoolean(true);

            dos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testDataOutputStreamEx02(){

        ByteArrayOutputStream bos = null;
        DataOutputStream dos = null;

        byte[]  result = null;

        try {
            bos = new ByteArrayOutputStream();
            dos = new DataOutputStream(bos);
            dos.writeInt(10);
            dos.writeFloat(20.0f);
            dos.writeUTF("test");
            dos.writeBoolean(true);

            result = bos.toByteArray();

            String[] hex = new String[result.length];

            for (int i = 0; i < result.length; i++){
                if (result[i] < 0){
                    hex[i] = String.format("%02x", result[i]+256);
                }else {
                    hex[i] = String.format("%02x", result[i]);
                }
            }

            System.out.println("10진수 : "+ Arrays.toString(result));
            System.out.println("16진수 : "+ Arrays.toString(hex));
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
