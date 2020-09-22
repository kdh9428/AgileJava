package sis.report;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sis.studentinfo.Student;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ReportCardTest {

    private ReportCard card;

    @BeforeEach
    protected void setUp() {
        card = new ReportCard();
    }

    @Test
    public void testMessage() {

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

    @Test
    public void testKeys() {
        Set<Student.Grade> expectedGrades = new HashSet<>();


        expectedGrades.add(Student.Grade.A);
        expectedGrades.add(Student.Grade.B);
        expectedGrades.add(Student.Grade.C);
        expectedGrades.add(Student.Grade.D);
        expectedGrades.add(Student.Grade.F);

        Set<Student.Grade> grades = new HashSet<>();

        for (Student.Grade grade : card.getMessages().keySet()) {
            System.out.println(grade);
            grades.add(grade);
        }
        assertEquals(expectedGrades, grades);
    }

    @Test
    public void testValues() {
        List<String> expectedMessages = new ArrayList<>();
        expectedMessages.add(ReportCard.A_MESSAGE);
        expectedMessages.add(ReportCard.B_MESSAGE);
        expectedMessages.add(ReportCard.C_MESSAGE);
        expectedMessages.add(ReportCard.D_MESSAGE);
        expectedMessages.add(ReportCard.F_MESSAGE);

        Collection<String> messages = card.getMessages().values();
        for (String message : messages)
            assertTrue(expectedMessages.contains(message));

        assertEquals(expectedMessages.size(), messages.size());
    }

    @Test
    public void testEntries() {
        Set<Entry> entries = new HashSet<>();

        for (Map.Entry<Student.Grade, String> entry : card.getMessages().entrySet()) {

            entries.add(new Entry(entry.getKey(), entry.getValue()));
        }

        Set<Entry> expectedEntries = new HashSet<>();
        expectedEntries.add(new Entry(Student.Grade.A, ReportCard.A_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.B, ReportCard.B_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.C, ReportCard.C_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.D, ReportCard.D_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.F, ReportCard.F_MESSAGE));

        assertEquals(expectedEntries, entries);
    }
}

class Entry {
    private Student.Grade grade;
    private String message;

    public Entry(Student.Grade grade, String message) {
        this.grade = grade;
        this.message = message;
    }

    @Override
    public int hashCode() {
        final int hashMultiplier = 41;
        int result = 7;
        result = result * hashMultiplier + grade.hashCode();
        result = result * hashMultiplier + message.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Entry that = (Entry) obj;

        return this.grade == that.grade && this.message.equals(message);
    }
}