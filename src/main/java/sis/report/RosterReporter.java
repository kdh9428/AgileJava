package sis.report;

import sis.studentinfo.Session;
import sis.studentinfo.Student;
import sis.studentinfo.CourseSession;
import sis.util.StringUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class RosterReporter {

    //    public static final String NEWLINE = System.getProperty("line.separator");
    public static final String ROSTER_REPORT_HEADER = "Student %n-%n";
    public static final String ROSTER_REPORT_FOOTER = "%n# studnets = %d%n";

    private Session session;

    private Writer writer;

    public RosterReporter(Session session) {

        this.session = session;
    }

    public String getReport() {

        StringBuilder buffer = new StringBuilder();
//        buffer.append(ROSTER_REPORT_HEADER);


//        Student student = students.get(0);
//        buffer.append(student.getName());
//        buffer.append(NEWLINE);
//
//        student = students.get(1);
//        buffer.append(student.getName());
//        buffer.append(NEWLINE);

//        for (Student student : session.getAllStudents()){
//            buffer.append(student.getName());
//            buffer.append(NEWLINE);
//        }

//        buffer.append(ROSTER_REPORT_FOOTER + session.getAllStudents().size() + NEWLINE);

        //리팩토링 메서드 분리
//        writeHeader(buffer);
//        writeBody(buffer);
//        writeFooter(buffer);

        return buffer.toString();
    }

    void writeHeader() throws IOException {
        writer.write(String.format(ROSTER_REPORT_HEADER));
    }

    void writeBody() throws IOException {
        for (Student student : session.getAllStudents()) {
            writer.write(String.format(student.getName() + "%n"));
        }
    }

    void writeFooter() throws IOException {
        writer.write(String.format(ROSTER_REPORT_FOOTER, session.getAllStudents().size()));
//        buffer.append(ROSTER_REPORT_FOOTER + session.getAllStudents().size() + StringUtil.NEWLINE);
    }

    public void writeReport(Writer writer) throws IOException {
        this.writer = writer;
        writeHeader();
        writeBody();
        writeFooter();
    }

    public void writeReport(String filename) throws IOException {

        Writer bufferedWriter = new BufferedWriter(new FileWriter(filename));

        try {
            writeReport(bufferedWriter);
        } finally {
            bufferedWriter.close();
        }
    }
}
