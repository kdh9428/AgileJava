package sis.studentinfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentDirectoryTest {

    private StudentDirectory directory;

    @BeforeEach
    public void setUp() {
        directory = new StudentDirectory();
    }

    @Test
    public void testStoreAndRetrieve() {
        final int numberOfStudents = 10;

        for (int i = 0; i < numberOfStudents; i++) {
            addStudent(directory, i);
        }

        for (int i = 0; i < numberOfStudents; i++) {
            verifyStudentLookup(directory, i);
        }
    }

    private void verifyStudentLookup(StudentDirectory directory, int i) {
        String id = "" + i;
        Student student =directory.findById(id);
        assertEquals(id, student.getLastName());
        assertEquals(id, student.getId());
        assertEquals(i, student.getCredits());
    }

    private void addStudent(StudentDirectory directory, int i) {
        String id = "" + i;
        Student student = new Student(id);

        student.setId(id);
        student.addCredits(i);
        directory.add(student);

    }


}