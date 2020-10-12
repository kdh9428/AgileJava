package sis.ui;

import sis.studentinfo.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentUI {

    static final String MENU = "(A)dd or (Q)uit?";
    static final String ADD_OPTION = "A";
    static final String QUIT_OPTION = "Q";
    static final String NAME_PROMPT = "NAME: ";
    static final String ADDED_MESSAGE = "Added";


    private BufferedReader reader;
    private BufferedWriter writer;

    private List<Student> students = new ArrayList<>();

    public StudentUI(BufferedReader reader, BufferedWriter writer){
        this.reader = reader;
        this.writer = writer;
    }

    public void run() throws IOException {

        String line;
        do {
            write(MENU);
            line = reader.readLine();
            if (line.equals(ADD_OPTION))
                addStudent();
        }while (!line.equals(QUIT_OPTION));
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
}
