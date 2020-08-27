package sis.studentinfo;

import java.util.ArrayList;

public class Student {

    enum Grade {A, B, C, D, F}

    private String name;
    private int credits;
    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "CO";
    private String state = "";

    private ArrayList<Grade> grades = new ArrayList<>();
    private GradingStrategy gradingStrategy = new RegularGradingStrategy();

    public Student(String name) {
        this.name = name;
        credits = 0;
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

        if (grades.isEmpty())
            return 0.0;
        double total = 0.0;

        for (Grade grade : grades) {
            total += gradingStrategy.getGradePointsFor(grade);
        }
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
}
