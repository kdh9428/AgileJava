package sis.studentinfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static sis.studentinfo.DateUtil.createDate;

abstract public class SessionTest {
    private Session session;
    private Date startDate;
    private static final int CREDITS = 3;

    abstract protected Session createSession(Course course, Date startDate);

    @BeforeEach
    public void setUp() {
        startDate = createDate(2003, 1, 6);
//        session = CourseSession.create("ENGL", "101", startDate);
//        session = createCourseSession();
        session =  createSession(new Course("ENGL", "101"), startDate);
        session.setNumberOfCredits(CREDITS);
    }

    @Test
    public void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());

        CourseSession.resetCount();
        createCourseSession();
        assertEquals(1, CourseSession.getCount());
        createCourseSession();
        assertEquals(2, CourseSession.getCount());
    }

    private CourseSession createCourseSession() {

//        CourseSession session = CourseSession.create("ENEL", "101", startDate);
        CourseSession session = (CourseSession) CourseSession.create(new Course("ENEL", "101"), startDate);
        session.setNumberOfCredits(SessionTest.CREDITS);
        return session;

    }

    @Test
    public void testEnrollStudents() {
        Student student1 = new Student("Cain Divoe");
        session.enroll(student1);
        assertEquals(CREDITS, student1.getCredits());
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));

        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);
        assertEquals(CREDITS, student2.getCredits());
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));
    }

    @Test
    public void testComparable() {
        final Date date = new Date();

        Session sessionA = createSession(new Course("CMSC", "101"), date);
        Session sessionB = createSession(new Course("ENGL", "101"), date);

        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);

        Session sessionC = createSession(new Course("CMSC", "101"), date);
        assertEquals(0, sessionA.compareTo(sessionC));

        Session sessionD = createSession(new Course("CMSC", "210"), date);
        assertTrue(sessionC.compareTo(sessionD) < 0);
        assertTrue(sessionD.compareTo(sessionC) > 0);

    }

    @Test
    public void testSessionLength() {
        Session session = createSession(new Course("CMSC", "210"), new Date());
        assertTrue(session.getSessionLength() > 0);
    }

    @Test
    public void testAverageGpaForPartTimeStudents() {
        session.enroll(createFullTimeStudent());
        Student partTimer1 = new Student("학생1");
        partTimer1.addGrade(Student.Grade.A);
        session.enroll(partTimer1);

        session.enroll(createFullTimeStudent());

        Student partTimer2 = new Student("학생2");
        partTimer2.addGrade(Student.Grade.B);
        session.enroll(partTimer2);

        assertEquals(3.5, session.averageGpaForPartTimeStudents(), 0.05);
    }

    private Student createFullTimeStudent() {
        Student student = new Student("학생 A");
        student.addCredits(Student.CREDITS_REQUIRED_FOR_FULL_TIME);
        return student;
    }

    @Test
    public void testIterate() {
        enrollStudents(session);

        List<Student> results = new ArrayList<>();
        for (Student student : session) {
            results.add(student);
        }

        assertEquals(session.getAllStudents(), results);

    }

    private void enrollStudents(Session session) {
        session.enroll(new Student("1"));
        session.enroll(new Student("2"));
        session.enroll(new Student("3"));
    }

    @Test
    public void testSessionUrl() throws SessionException {
        final String url = "http://course.langrsoft.com/cmsc300";
        session.setUrl(url);
        assertEquals(url, session.getUrl().toString());
    }

    @Test
    public void testInvalidSessionUrl() {
        final String url = "http://course.langrsoft.com/cmsc300";

        try {
            session.setUrl(url);
//            fail("expected exception due to invalid protocol in URL");
        } catch (SessionException expectedException) {
            Throwable cause = expectedException.getCause();
            assertEquals(MalformedURLException.class, cause.getClass());
        }
    }

    @Test
    public void testBadlyFormattedName() {

        final String studentName = "a b c d";
        try {
            new Student("a b c d");

//            fail("expected exception from 4-part name");
        } catch (StudentNameFormatException expectedException) {
            expectedException.printStackTrace();
            assertEquals(String.format(Student.TOO_MANY_NAME_PARTS_MSG, studentName, Student.MAX_NAME_PARTS), expectedException.getMessage());
        }

    }
}
