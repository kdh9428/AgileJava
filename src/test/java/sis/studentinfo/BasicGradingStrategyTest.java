package sis.studentinfo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicGradingStrategyTest {

    @Test
    public void testGetGradePoints(){
        GradingStrategy strategy = new BasicGradingStrategy();

        assertEquals(4, strategy.getGradePointsFor(Student.Grade.A));
        assertEquals(3, strategy.getGradePointsFor(Student.Grade.B));
        assertEquals(2, strategy.getGradePointsFor(Student.Grade.C));
        assertEquals(1, strategy.getGradePointsFor(Student.Grade.D));
        assertEquals(0, strategy.getGradePointsFor(Student.Grade.F));

    }

}