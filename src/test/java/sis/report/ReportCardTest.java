package sis.report;

import org.junit.jupiter.api.Test;
import sis.studentinfo.Student;

import static org.junit.jupiter.api.Assertions.*;

public class ReportCardTest {

    @Test
    public void testMessage() {
        ReportCard card = new ReportCard();
        assertEquals(ReportCard.A_MESSAGE, card.getMessage(Student.Grade.A));
        assertEquals(ReportCard.B_MESSAGE, card.getMessage(Student.Grade.B));
        assertEquals(ReportCard.C_MESSAGE, card.getMessage(Student.Grade.C));
        assertEquals(ReportCard.D_MESSAGE, card.getMessage(Student.Grade.D));
        assertEquals(ReportCard.F_MESSAGE, card.getMessage(Student.Grade.F));

        System.out.println(card.getMessage(Student.Grade.A));
        System.out.println(card.getMessage(Student.Grade.B));
        System.out.println(card.getMessage(Student.Grade.C));
        System.out.println(card.getMessage(Student.Grade.D));
    }


}