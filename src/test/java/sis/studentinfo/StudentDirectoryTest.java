package sis.studentinfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentDirectoryTest {

    private StudentDirectory dir;

    @BeforeEach
    public void setUp() throws IOException {
        dir = new StudentDirectory();
    }

    protected void tearDown() throws IOException {
        dir.close();
        dir.remove();
    }


    @Test
    public void testRandomAccess() throws IOException {
        final int numberOfStudents = 10;
        for (int i = 0; i < numberOfStudents; i++) {
            addStudent(dir, i);
        }

        dir.close();

        dir = new StudentDirectory();
        for (int i = 0; i < numberOfStudents; i++) {
            verifyStudentLookup(dir, i);
        }
    }

    @Test
    public void testStoreAndRetrieve() throws IOException {
        final int numberOfStudents = 10;

        for (int i = 0; i < numberOfStudents; i++) {
            addStudent(dir, i);
        }

        for (int i = 0; i < numberOfStudents; i++) {
            verifyStudentLookup(dir, i);
        }
    }

    private void verifyStudentLookup(StudentDirectory directory, int i) throws IOException {
        String id = Integer.toString(i);
        Student student = directory.findById(id);
        System.out.println("===============");
        String lastName = student.getLastName();
        System.out.println(lastName);
        System.out.println(directory);

        assertEquals(0, student.getLastName());
        assertEquals(id, student.getId());
        assertEquals(i, student.getCredits());
    }

    private void addStudent(StudentDirectory directory, int i) throws IOException {
        String id = "" + i;
        Student student = new Student(id);

        student.setId(id);
        student.addCredits(i);
        directory.add(student);
    }
}