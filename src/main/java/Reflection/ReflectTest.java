package Reflection;

import java.util.ArrayList;

public class ReflectTest {

    private String privateStr;
    protected String protectedStr;
    public String publicStr;

    public ArrayList<String> getArrayList() {
        System.out.println("매개변수가 없는 메서드 호출");
        return new ArrayList<>();
    }

    public ArrayList<String> getArrayList(int number) {
        System.out.println("매개변수가 있는 메서드 호출");
        return new ArrayList<>();
    }

    public String[] getStringArray() {
        return new String[5];
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }
    private void setStringArray(String[] array){

    }
}
