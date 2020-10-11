package sis.ui;

import sis.studentinfo.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

    public void run(){

    }

    public List<Student> getAddedStudents() {

        return students;
    }
}
