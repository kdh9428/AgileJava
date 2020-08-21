package sis.report;

import sis.studentinfo.Student;
import sis.report.RosterReporter;
import sis.studentinfo.CourseSession;
import org.junit.jupiter.api.Test;
import sis.studentinfo.DateUtil;

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


        CourseSession session = new CourseSession("ENGL", "101", new DateUtil().createDate(2003, 1, 6));
        Student studentA = new Student("A");
        Student studentB = new Student("B");

        session.enroll(studentA);
        session.enroll(studentB);
        String rosterReport = new RosterReporter(session).getReport();

        System.out.println(rosterReport);
        assertEquals(RosterReporter.ROSTER_REPORT_HEADER + "A" + RosterReporter.NEWLINE + "B" + RosterReporter.NEWLINE +
                RosterReporter.ROSTER_REPORT_FOOTER + "2" + RosterReporter.NEWLINE, rosterReport);
    }
}