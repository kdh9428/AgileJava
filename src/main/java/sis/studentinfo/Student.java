package sis.studentinfo;

import java.io.Closeable;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.sql.DriverManager.getConnection;

public class Student implements Serializable {

    public static Logger logger = Logger.getLogger(Student.class.getName());

    public enum Grade {
        A(4), B(3), C(2), D(1), F(0);

        private int point;

        Grade(int point) {
            this.point = point;
        }

        int getPoint() {
            return point;
        }
    }

    public enum Flag {

        ON_CAMPUS(1), TAX_EXEMPT(2), MINOR(4), TROUBLEMAKER(8);

        private int mask;

        Flag(int mask) {
            this.mask = mask;
        }
    }

    private int settings = 0x0; //1, 2, 4

    public void set(Flag... flags) {
        System.out.println(3 | 4);
        for (Flag flag : flags)
            settings |= flag.mask;
    }

    public void unset(Flag... flags) {
        for (Flag flag : flags) {
            settings &= ~flag.mask;
        }
    }

    public boolean isOn(Flag flag) {
        return (settings & flag.mask) == flag.mask;
    }

    public boolean isOff(Flag flag) {
        return !isOn(flag);
    }

    private String id;
    private String name;
    private int credits;
    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "CO";
    private String state = "";
    private String firstName = "";
    private String middleName = "";
    private String lastName;

    private ArrayList<Grade> grades = new ArrayList<>();
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();
    static final String TOO_MANY_NAME_PARTS_MSG = "Student name '%s' contains more than %d parts";
    public static final int MAX_NAME_PARTS = 3;

    public Student(String fullName) {
        this.name = fullName;
        credits = 0;

        List<String> nameParts = split(fullName);
        final int maximumNumberOfNameParts = 3;
        if (nameParts.size() > maximumNumberOfNameParts) {
            String message = String.format(Student.TOO_MANY_NAME_PARTS_MSG, fullName, MAX_NAME_PARTS);
            Student.logger.info(message);
            throw new StudentNameFormatException(message);
        }
        setName(nameParts);
    }

    private void log(String message) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.info(message);
    }

    private void setName(List<String> nameParts) {

        this.lastName = removeLast(nameParts);
        System.out.println(this.lastName);
        String name = removeLast(nameParts);
        if (nameParts.isEmpty()) {
            this.firstName = name;
        } else {
            this.middleName = name;
            this.firstName = removeLast(nameParts);
        }
    }

    private String removeLast(List<String> list) {

        if (list.isEmpty()) {
            return "";
        }
        return list.remove(list.size() - 1);
    }

    public String getName() {
        return name;
    }

    public boolean isFullTime() {
        return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public int getCredits() {
        return credits;
    }

    public void addCredits(int credits) {
        this.credits += credits;
    }

    public boolean isInState() {
        return state.equals(Student.IN_STATE);
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getGpa() {


        Student.logger.fine("begin getGpa " + System.currentTimeMillis());
        if (grades.isEmpty())
            return 0.0;
        double total = 0.0;

        for (Grade grade : grades) {
            total += gradingStrategy.getGradePointsFor(grade);
        }

        Student.logger.fine("end getGpa " + System.currentTimeMillis());
        return total / grades.size();
    }


    private double gradePointsFor(Grade grade) {
        return gradingStrategy.getGradePointsFor(grade);
    }

    void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    private List<String> split(String fullName) {
        List<String> results = new ArrayList<>();

        for (String name : fullName.split(" ")) {
            results.add(name);
        }

        return results;
    }

    public static int countChars(String input, char ch) {
        int count;
        int i;
        for (i = 0, count = 0; i < input.length(); i++) {
            if (input.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPalindrome(String string) {

        if (string.length() == 0) {
            return true;
        }

        int limit = string.length() / 2;

        for (int forward = 0, backward = string.length() - 1; forward < limit; forward++, backward--) {

            if (string.charAt(forward) != string.charAt(backward))
                return false;
        }
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public static Student findByLastName(String lastName) throws RuntimeException{
//        Connection dbConnection = null;
//        try {
//            dbConnection = getConnection();
//            return lookup(dbConnection, lastName);
//        }catch (SQLException e){
//            throw new RuntimeException(e.getMessage());
//        }finally {
//            close((Closeable) dbConnection);
//        }
//}

    public static Student findByLastName(String lastName) throws RuntimeException {

        System.out.println(lastName);

        return new Student("a");
    }
}
