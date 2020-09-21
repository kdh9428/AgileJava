package sis.studentinfo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SummerCourseSession extends Session {

    //    public static SummerCourseSession create(String department, String number, Date startDate) {
//        return new SummerCourseSession(department, number, startDate);
//    }

    public static SummerCourseSession create(Course course, Date startDate) {
        return new SummerCourseSession(course, startDate);
    }

//    private SummerCourseSession(String department, String number, Date startDate) {
//        super(department, number, startDate);
//    }

    private SummerCourseSession(Course course, Date startDate){
        super(course, startDate);
    }

    @Override
    protected int getSessionLength() {
        return 8;
    }
}
