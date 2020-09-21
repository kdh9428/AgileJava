package sis.studentinfo;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SummerCourseSessionTest extends SessionTest {
    @Test
    public void testEndDate() {
        Date startDate = DateUtil.createDate(2003, 6, 9);

//        Session session = createSession("ENGL", "200", startDate);
        Session session = createSession(new Course("ENGL", "200"), startDate);
        Date eightWeekOut = DateUtil.createDate(2003, 8, 1);
        assertEquals(eightWeekOut, session.getEndDate());
    }

//    protected Session createSession(String department, String number, Date date){
//        return SummerCourseSession.create(department, number, date);
//    }

    @Override
    protected Session createSession(Course course, Date date) {
        return SummerCourseSession.create(course, date);
    }
}