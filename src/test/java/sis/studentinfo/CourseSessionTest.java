package sis.studentinfo;

import sis.studentinfo.Student;
import sis.studentinfo.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sis.studentinfo.CourseSession;

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
        Session session = createSession("ENGL", "200", startDate);

        Date sixteenWeeksOut = createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }

    @Test
    public void testCount(){
        CourseSession.resetCount();
        createSession("","",new Date());
        assertEquals(1, CourseSession.getCount());

        createSession("","",new Date());
        assertEquals(2, CourseSession.getCount());
    }

    protected Session createSession(String department,
                                    String number,
                                    Date date){
        return CourseSession.create(department, number, date);

    }

}
