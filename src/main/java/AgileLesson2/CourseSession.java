package AgileLesson2;

import AgileLesson1.Student;

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
public class CourseSession {

    private String department;
    private String number;

    private ArrayList<Student> students = new ArrayList<Student>();

    private Date startDate;

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

    public CourseSession(String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }

    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public void enroll(Student student) {
        students.add(student);
    }

    public Student get(int index) {
        return students.get(index);
    }

    /**
     * @return Date the last date of the course session
     */
    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        int numberOfDays = 16 * 7 - 3;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }

    public Date getStartDate() {
        return startDate;
    }

    public ArrayList<Student> getAllStudents(){
        return students;
    }
}