package sis.studentinfo;

import java.util.*;

abstract public class Session implements Comparable<Session>, Iterable<Student> {


    private static int count;
    private String department;
    private String number;
    private List<Student> students = new ArrayList<>();
    private Date startDate;
    private int numberOfCredits;

    protected Session(String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
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

    int getNumberOfStudents() {
        return students.size();
    }

    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
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

        for (Iterator<Student> it = students.iterator(); it.hasNext();){
            Student student = it.next();
            if (student.isFullTime()){
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
}

