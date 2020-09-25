package sis.studentinfo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Handler;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private static final double GRADE_TOLERANCE = 0.05;

    @Test
    public void testCreate() {
        final String firstStudentName = "Jane Doe";

        Student firstStudent = new Student(firstStudentName);
        assertEquals(firstStudentName, firstStudent.getName());
        assertEquals("Jane", firstStudent.getFirstName());
        assertEquals("Doe", firstStudent.getLastName());
        assertEquals("", firstStudent.getMiddleName());

        System.out.println("==========================================");
        final String secondStudentName = "Blow";
        Student secondStudent = new Student(secondStudentName);
        assertEquals(secondStudentName, secondStudent.getName());
        assertEquals("", secondStudent.getFirstName());
        assertEquals("Blow", secondStudent.getLastName());
        assertEquals("", secondStudent.getMiddleName());

        System.out.println("==========================================");
        final String thirdStudentName = "Raymond Douglas Davies";
        Student thirdStudent = new Student(thirdStudentName);
        assertEquals(thirdStudentName, thirdStudent.getName());
        assertEquals("Raymond", thirdStudent.getFirstName());
        assertEquals("Davies", thirdStudent.getLastName());
        assertEquals("Douglas", thirdStudent.getMiddleName());
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

    @Test
    public void testCalculateGpa() {

        Student student = new Student("a");


        assertGpa(student, 0.0);

        student.addGrade(Student.Grade.A);
        assertGpa(student, 4.0);

        student.addGrade(Student.Grade.B);
        assertGpa(student, 3.5);

        student.addGrade(Student.Grade.C);
        assertGpa(student, 3.0);

        student.addGrade(Student.Grade.D);
        assertGpa(student, 2.5);

        student.addGrade(Student.Grade.F);
        assertGpa(student, 2.0);
    }

    private void assertGpa(Student student, double expectedGpa) {
        assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
    }

    @Test
    public void testCalculateHonorsStudentGpa() {
        assertGpa(createHonorsStudent(), 0.0);
        assertGpa(createHonorsStudent(Student.Grade.A), 5.0);
        assertGpa(createHonorsStudent(Student.Grade.B), 4.0);
        assertGpa(createHonorsStudent(Student.Grade.C), 3.0);
        assertGpa(createHonorsStudent(Student.Grade.D), 2.0);
        assertGpa(createHonorsStudent(Student.Grade.F), 0.0);
    }

    private Student createHonorsStudent() {
        Student student = new Student("a");

        student.setGradingStrategy(new HonorsGradingStrategy());
        return student;
    }

    private Student createHonorsStudent(Student.Grade grade) {
        Student student = new Student("a");
        student.addGrade(grade);
        student.setGradingStrategy(new HonorsGradingStrategy());
        return student;
    }

    public List<String> splitToken(String name) {
        List<String> results = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(name, " ");

        while (tokenizer.hasMoreTokens())
            results.add(tokenizer.nextToken());

        return results;
    }

    @Test
    public void testBodyFormattedName(){

        Handler handler = new HandlerTest();
        Student.logger.addHandler(handler);

        final String studentName =  "a b c d";
        try {
            new Student(studentName);
            fail("expected exception from 4-part name");
        }catch (StudentNameFormatException expectedException){
            String message = String.format(Student.TOO_MANY_NAME_PARTS_MSG, studentName, Student.MAX_NAME_PARTS);
            assertEquals(message, expectedException.getMessage());
            assertEquals(message, ((HandlerTest)handler).getMessage());
        }
    }

    private boolean wasLogged(String message, HandlerTest handler){
        return message.equals(handler.getMessage());
    }


    @Test
    public void testLoggingHierarchy(){
        Logger logger = Logger.getLogger("sis.studentinfo.Student");
        assertTrue(logger == Logger.getLogger("sis.studentinfo.Student"));

        Logger parent = Logger.getLogger("sis.studentinfo");
        assertEquals(parent, logger.getParent());
        assertEquals(Logger.getLogger("sis"),parent.getParent());

    }


}

