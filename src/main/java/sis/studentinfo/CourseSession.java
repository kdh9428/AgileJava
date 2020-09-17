package sis.studentinfo;

import java.util.*;


/**
 * Provides a representation of a single-semester
 * session of a specific university course.
 *
 * @author Administrator
 */
public class CourseSession extends Session {

    private static int count;

    //    public static CourseSession create(String department, String number, Date startDate){
//        return new CourseSession(department,number,startDate);
//    }
    public static Session create(Course course, Date startDate) {
        CourseSession.incrementCount();
        return new CourseSession(course, startDate);
    }

    protected CourseSession(Course course, Date startDate) {
        super(course, startDate);
    }

    private static void incrementCount() {
        ++count;
    }

    static void resetCount() {
        count = 0;
    }

    static int getCount() {
        return count;
    }

    protected int getSessionLength() {
        return 16;
    }
}