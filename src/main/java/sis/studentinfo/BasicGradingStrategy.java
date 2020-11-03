package sis.studentinfo;

import java.io.Serializable;

public class BasicGradingStrategy implements GradingStrategy, Serializable {
    @Override
    public int getGradePointsFor(Student.Grade grade) {
        return grade.getPoint();
    }
}
