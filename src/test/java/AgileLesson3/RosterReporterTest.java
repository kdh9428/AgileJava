package AgileLesson3;

import AgileLesson1.Student;
import AgileLesson2.CourseSession;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class RosterReporterTest {

    @Test
    public void unicode() {
        char capitalA = 'A';

        assertEquals('\u0041', capitalA);
        assertEquals('\101', capitalA);
    }

    @Test
    public void stringConcatenation() {

        assertEquals("abcd", "ab".concat("cd"));
    }
    @Test
    public void testRosterReport() {

        CourseSession session = new CourseSession("ENGL", "101", createDate(2003, 1, 6));

        Student studentA = new Student("A");
        Student studentB = new Student("B");

        session.enroll(studentA);
        session.enroll(studentB);
        String rosterReport = new RosterReporter(session).getReport();

        assertEquals(RosterReporter.ROSTER_REPORT_HEADER + "A" + RosterReporter.NEWLINE + "B" + RosterReporter.NEWLINE +
                RosterReporter.ROSTER_REPORT_FOOTER + "2" + RosterReporter.NEWLINE, rosterReport);

    }

    private Date createDate(int year, int month, int date) {

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, date);

        System.out.println(calendar.getTime());

        return calendar.getTime();
    }
}