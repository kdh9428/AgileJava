package sis.studentinfo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

abstract public class Session implements Comparable<Session>, Iterable<Student> {


    private static int count;
    private String department;
//    private String number;
    private Course course;
    private List<Student> students = new ArrayList<>();
    private Date startDate;
    private int numberOfCredits;

    private URL url;

    protected Session(Course course, Date startDate) {
        this.course = course;
        this.startDate = startDate;
    }

    @Override
    public int compareTo(Session that) {

        int compare = this.getDepartment().compareTo(that.getDepartment());

        if (compare != 0)
            return compare;

        return this.getNumber().compareTo(that.getNumber());
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public String getDepartment() {
        return course.getDepartment();
    }

    public String getNumber() {
        return course.getNumber();
    }

    public void enroll(Student student) {
        student.addCredits(numberOfCredits);
        students.add(student);
    }

    Student get(int index) {
        return students.get(index);
    }

    protected Date getStartDate() {
        return startDate;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    abstract protected int getSessionLength();

    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getStartDate());
        final int daysInWeek = 7;
        final int daysFromFridayToMonday = 3;

        int numberOfDays = getSessionLength() * daysInWeek - daysFromFridayToMonday;

        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }

    double averageGpaForPartTimeStudents() {
        double total = 0;
        int count = 0;

        for (Iterator<Student> it = students.iterator(); it.hasNext(); ) {
            Student student = it.next();
            if (student.isFullTime()) {
                continue;
            }
            count++;
            total += student.getGpa();
        }

//        for (Student student : students) {
//            if (student.isFullTime()) {
//                continue;
//            }
//            count++;
//            total += student.getGpa();
//        }
        if (count == 0) return 0.0;
        return total / count;
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(String urlString) throws SessionException {
        try {
            this.url = new URL(urlString);

        } catch (MalformedURLException e) {
            log(e);
            throw new SessionException(e);
        }
    }

    private void log(Exception e) {
        e.printStackTrace();
    }



}


