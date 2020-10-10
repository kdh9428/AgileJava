package sis.report;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sis.studentinfo.*;

import java.io.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RosterReporterTest {

    private Session session;

    @BeforeEach
    void setUp() {
        session = CourseSession.create(new Course("ENGL", "101"), DateUtil.createDate(2003, 1, 6));

        session.enroll(new Student("A"));
        session.enroll(new Student("B"));
    }

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

        Writer writer = new StringWriter();
        new RosterReporter(session).writeReport(writer);
        String rosterReport = writer.toString();

//        String rosterReport = new RosterReporter((CourseSession) session).getReport();

        assertReportContents(writer.toString());
    }

    private void assertReportContents(String rosterReport) {
        assertEquals(String.format(RosterReporter.ROSTER_REPORT_HEADER + "A%n" + "B%n" + RosterReporter.ROSTER_REPORT_FOOTER, session.getNumberOfStudents()), rosterReport);
    }

    @Test
    public void testFiledReport() throws IOException {
        final String filename = "testFiledReport.txt";

        try {
            delete(filename);
            new RosterReporter(session).writeReport(filename);

            StringBuffer buffer = new StringBuffer();
            String line;

            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while ((line = reader.readLine()) != null){
                buffer.append(String.format(line + "%n"));
            }

            reader.close();

            assertReportContents(buffer.toString());
        }finally {
            delete(filename);
        }

    }

    private void delete(String filename) {
        File file = new File(filename);
        if (file.exists())
            assertTrue("unable to delete " + filename, file.delete());
    }

}