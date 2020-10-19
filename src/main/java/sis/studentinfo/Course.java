package sis.studentinfo;

import java.io.Serializable;

public class Course implements Serializable {


    private String department;
    private String number;

    public Course(String department, String number) {
        this.department = department;
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass())
            return false;

        if (!(obj instanceof Course))
            return false;

        Course that = (Course) obj;
        return this.department.equals(that.department) && this.number.equals(that.number);
    }

    @Override
    public int hashCode() {
        final int hashMultiplier = 41;
        int result = 7;
        result = result * hashMultiplier + department.hashCode();
        result = result * hashMultiplier + number.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return department+" "+number;
    }
}

