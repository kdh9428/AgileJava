package sis.studentinfo;

import com.sun.source.tree.CaseTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HonorsGradingStrategyTest {
    enum Score{
        fieldGoal, touchdown, extraPoint, twoPointConversion, safety
    }

    @Test
    public void testSwitchResults(){

        int totalPoints = 0;

        Score score = Score.touchdown;

        switch (score){
            case fieldGoal:
                totalPoints +=3;
                break;
            case touchdown:
                totalPoints +=6;
                break;
            case extraPoint:
                totalPoints +=1;
                break;
            case twoPointConversion:
                totalPoints +=2;
                break;
            case safety:
                totalPoints +=2;
                break;
        }
        assertEquals(6, totalPoints);
    }

    @Test
    public void testGetGradePoints(){
        GradingStrategy strategy = new HonorsGradingStrategy();

        assertEquals(5, strategy.getGradePointsFor(Student.Grade.A));
        assertEquals(4, strategy.getGradePointsFor(Student.Grade.B));
        assertEquals(3, strategy.getGradePointsFor(Student.Grade.C));
        assertEquals(2, strategy.getGradePointsFor(Student.Grade.D));
        assertEquals(0, strategy.getGradePointsFor(Student.Grade.F));
    }
}