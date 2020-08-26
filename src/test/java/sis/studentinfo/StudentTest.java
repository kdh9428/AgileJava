package sis.studentinfo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {


    @Test
    public void testCreate() {
        final String firstStudentName = "Jane Doe";

        Student student = new Student(firstStudentName);
        assertEquals(firstStudentName, student.getName());


        final String secondStudentName = "Joe Blow";
        Student secondStudent = new Student(secondStudentName);
        assertEquals(secondStudentName, secondStudent.getName());

        assertEquals(firstStudentName, student.getName());

        student = new Student("a");
        assertEquals(0, student.getCredits());
        student.addCredits(3);
        assertEquals(3, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(4);
        assertEquals(7, student.getCredits());
        assertFalse(student.isFullTime());

    }

    @Test
    public void testFullTime() {
        Student student = new Student("a");
        assertFalse(student.isFullTime());
    }

    @Test
    public void testStudentStatus() {
        Student student = new Student("a");

        assertEquals(0, student.getCredits());
        student.addCredits(3);
        assertEquals(3, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(4);
        assertEquals(7, student.getCredits());
        assertFalse(student.isFullTime());


        student.addCredits(5);
        assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
        assertTrue(student.isFullTime());
    }

    @Test
    public void testInState() {
        Student student = new Student("A");

        assertFalse(student.isInState());

        student.setState(Student.IN_STATE);
        assertTrue(student.isInState());
        student.setState("MD");
        assertFalse(student.isInState());


    }
}
