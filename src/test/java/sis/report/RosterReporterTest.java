package sis.report;

import sis.studentinfo.*;
import sis.report.RosterReporter;
import org.junit.jupiter.api.Test;
import sis.util.StringUtil;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

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
    public void testRosterReport() throws IOException {


//        CourseSession session = CourseSession.create("ENGL", "101", DateUtil.createDate(2003, 1, 6));
        Session session = CourseSession.create(new Course("ENGL", "101"), DateUtil.createDate(2003, 1, 6));
        Student studentA = new Student("A");
        Student studentB = new Student("B");

        session.enroll(studentA);
        session.enroll(studentB);

        Writer writer = new StringWriter();
        new RosterReporter(session).writeReport(writer);
        String rosterReport = writer.toString();

//        String rosterReport = new RosterReporter((CourseSession) session).getReport();

        System.out.println(rosterReport);
        assertEquals(String.format(RosterReporter.ROSTER_REPORT_HEADER + "A%n" + "B%n" +
                RosterReporter.ROSTER_REPORT_FOOTER, 2), rosterReport);
    }
}