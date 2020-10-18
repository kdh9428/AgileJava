package sis.ui;

import org.junit.jupiter.api.Test;
import sis.studentinfo.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentUI {

    static final String MENU = "(A)dd or (Q)uit?";
    static final String ADD_OPTION = "A";
    static final String QUIT_OPTION = "Q";
    static final String NAME_PROMPT = "NAME: ";
    static final String ADDED_MESSAGE = "Added";


    private BufferedReader reader;
    private BufferedWriter writer;

    private List<Student> students = new ArrayList<>();

    public StudentUI() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void run() throws IOException {

        String line;
        do {
            write(MENU);
            line = reader.readLine();
            if (line.equals(ADD_OPTION))
                addStudent();
        } while (!line.equals(QUIT_OPTION));
    }

    private void addStudent() throws IOException {
        write(NAME_PROMPT);
        String name = reader.readLine();
        students.add(new Student(name));
        writeln(ADDED_MESSAGE);
    }

    private void writeln(String line) throws IOException {
        write(line);
        writer.newLine();
        writer.flush();
    }

    private void write(String line) throws IOException {
        writer.write(line, 0, line.length());
        writer.flush();
    }

    public List<Student> getAddedStudents() {
        return students;
    }

    public static void main(String[] args) throws IOException {
//        new StudentUI().run();
//        try {
//            int input = 0;
//            while ((input = System.in.read()) != -1) {
//                System.out.println("input : " + input + ", (char)input : " + (char) input);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(MENU, 0, MENU.length());
        writer.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String console = reader.readLine();
        System.out.println(console);

    }
}
