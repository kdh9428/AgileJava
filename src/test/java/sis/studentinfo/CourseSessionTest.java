package sis.studentinfo;

import sis.studentinfo.Student;
import sis.studentinfo.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sis.studentinfo.CourseSession;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static sis.studentinfo.DateUtil.createDate;

public class CourseSessionTest {

    private CourseSession session;
    private Date startDate;

    @BeforeEach
    public void setUp() {
        startDate = createDate(2003, 1, 6);
        session = CourseSession.create("ENGL", "101", startDate);
    }

    @Test
    public void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());

        CourseSession.resetCount();
//        createCourseSession();
        assertEquals(1, CourseSession.getCount());
        createCourseSession();
        assertEquals(2, CourseSession.getCount());
    }

    private CourseSession createCourseSession() {
        return CourseSession.create("ENEL","101",startDate);
    }

    @Test
    public void testEnrollStudents() {
        Student student1 = new Student("Cain Divoe");
        session.enroll(student1);
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));


        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);

        assertEquals(2, session.getNumberOfStudents());
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));
    }

    @Test
    public void testCourseDates() {
        Date sixteenWeeksOut = createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }

}
