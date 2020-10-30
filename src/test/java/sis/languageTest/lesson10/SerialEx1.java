package sis.languageTest.lesson10;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

public class SerialEx1 {

    @Test
    public void testUserInfoOutputSerial() {

        try {
            String fileName = "UserInfo.ser";

            FileOutputStream outputStream = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);

            ObjectOutputStream out = new ObjectOutputStream(bos);

            UserInfo u1 = new UserInfo("Man", "1234", 30);
            UserInfo u2 = new UserInfo("Woman", "4321", 26);

            ArrayList<UserInfo> list = new ArrayList<>();

            list.add(u1);
            list.add(u2);

            out.writeObject(u1);
            out.writeObject(u2);
            out.writeObject(list);
            out.close();
            System.out.println("직렬화 완료");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUserInfoInputSerial() {
        try {
            String fileName = "UserInfo.ser";

            FileInputStream inputStream = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(inputStream);

            ObjectInputStream in = new ObjectInputStream(bis);

            UserInfo u1 = (UserInfo) in.readObject();
            UserInfo u2 = (UserInfo) in.readObject();
            ArrayList u3 = (ArrayList) in.readObject();


            System.out.println(u1);
            System.out.println(u2);
            System.out.println(u3);
            in.close();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
