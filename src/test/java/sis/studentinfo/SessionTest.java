package sis.studentinfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static sis.studentinfo.DateUtil.createDate;

abstract public class SessionTest {
    private CourseSession session;
    private Date startDate;
    private static final int CREDITS = 3;

    abstract protected Session createSession(String department, String number, Date startDate);

    @BeforeEach
    public void setUp() {
        startDate = createDate(2003, 1, 6);
//        session = CourseSession.create("ENGL", "101", startDate);
        session = createCourseSession();
    }

    @Test
    public void testCreate() {
        assertEquals("ENEL", session.getDepartment());
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

        CourseSession session = CourseSession.create("ENEL", "101", startDate);
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

        Session sessionA = createSession("CMSC", "101", date);
        Session sessionB = createSession("ENGL", "101", date);

        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);

        Session sessionC = createSession("CMSC", "101", date);
        assertEquals(0, sessionA.compareTo(sessionC));

        Session sessionD = createSession("CMSC", "210", date);
        assertTrue( sessionC.compareTo(sessionD) < 0);
        assertTrue( sessionD.compareTo(sessionC) > 0);

    }

    @Test
    public void testSessionLength(){
        Session session = createSession("CMSC", "210", new Date());
        System.out.println(session.getSessionLength());
        assertTrue(session.getSessionLength() > 0);
    }

}
