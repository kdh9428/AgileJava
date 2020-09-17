package sis.studentinfo;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static sis.studentinfo.DateUtil.createDate;

public class CourseSessionTest extends SessionTest {

    private CourseSession session;
    private Date startDate;
    private static final int CREDITS = 3;

    @Test
    public void testCourseDates() {
        Date startDate = DateUtil.createDate(2003, 1, 6);
//        Session session = createSession("ENGL", "200", startDate);

        Session session = createSession(createCourse(), startDate);
        Date sixteenWeeksOut = createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }

    @Test
    public void testCount(){
        CourseSession.resetCount();
//        createSession("","",new Date());
        createSession(createCourse(),new Date());
        assertEquals(1, CourseSession.getCount());


//        createSession("","",new Date());
        createSession(createCourse(),new Date());
        assertEquals(2, CourseSession.getCount());
    }

    private Course createCourse() {
        return new Course("ENGL", "101");
    }

//    protected Session createSession(String department,
//                                    String number,
//                                    Date date){
//        return CourseSession.create(department, number, date);
//
//    }

    @Override
    protected Session createSession(Course course, Date date) {
        return CourseSession.create(course, date);
    }
}
