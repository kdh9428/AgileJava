package sis.languageTest.lesson10;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SuperUserInfo {
    String name;
    String password;

    public SuperUserInfo() {
        this("Unknown", "1111");
    }

    public SuperUserInfo(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

class UserInfo2 extends SuperUserInfo implements Serializable{

    int age;

    public UserInfo2() {
        this("Unknown", "1111",0);
    }

    public UserInfo2(String name, String password, int age) {
        super(name, password);
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo2{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }


    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.writeUTF(name);
        outputStream.writeUTF(password);
        outputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {

        name = inputStream.readUTF();
        password = inputStream.readUTF();
        inputStream.defaultReadObject();
    }
}
