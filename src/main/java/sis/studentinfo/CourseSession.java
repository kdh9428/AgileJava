package sis.studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Provides a representation of a single-semester
 * session of a specific university course.
 *
 * @author Administrator
 */
public class CourseSession implements Comparable<CourseSession> {


    private static int count;

    private String department;
    private String number;
    private ArrayList<Student> students = new ArrayList<>();
    private Date startDate;
    private int numberOfCredits;

    /**
     * Constructs a CourseSession starting on a specific date
     *
     * @param startDate the date on which the CourseSession begins
     */
    public CourseSession(Date startDate) {
        this.startDate = startDate;
    }

    public CourseSession(String department, String number) {
        this.department = department;
        this.number = number;
    }

    private CourseSession(String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }

    private static void incrementCount() {
        ++count;
    }


    static int getCount() {
        return count;
    }

    static void resetCount() {
        count = 0;
    }

    public static CourseSession create(String department, String number, Date startDate) {
        CourseSession.incrementCount();
        return new CourseSession(department, number, startDate);
    }

    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

    int getNumberOfStudents() {
        return students.size();
    }

    public void enroll(Student student) {
        student.addCredits(numberOfCredits);
        students.add(student);
    }

    Student get(int index) {
        return students.get(index);
    }

    /**
     * @return Date the last date of the course session
     */
    Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        int numberOfDays = 16 * 7 - 3;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }

    Date getStartDate() {
        return startDate;
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    @Override
    public int compareTo(CourseSession that) {

        int compare = this.getDepartment().compareTo(that.getDepartment());

        if (compare == 0)
            compare = this.getNumber().compareTo(that.getNumber());

        return compare;
    }
}