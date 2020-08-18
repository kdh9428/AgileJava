package AgileEx1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {


    @Test
    public void testCreate() {
        final String firstStudentName = "Jane Doe";

        Student student = new Student(firstStudentName);
        assertEquals(firstStudentName,student.getName());


        final String secondStudentName = "Joe Blow";
        Student secondStudent = new Student(secondStudentName);
        assertEquals(secondStudentName, secondStudent.getName());

        assertEquals(firstStudentName,student.getName());
        
    }
}
