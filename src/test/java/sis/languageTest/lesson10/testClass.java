package sis.languageTest.lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class testClass {

    public static void main(String[] args) {

        testClass testClass = new testClass();
        Object obj = testClass.func();
        for (int i=0; i < 5; i++){
            System.out.println(obj);
        }
    }

    public Object func(){

        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        class LocalInner{

            @Override
            public String toString(){

                StringBuilder builder = new StringBuilder();

                Iterator it = list.iterator();

                while (it.hasNext())
                    builder.append(it.next());

                list.add("hi ");
                return builder.toString();
            }
        }
        return new LocalInner();
    }

}
