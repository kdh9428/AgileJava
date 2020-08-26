package sis.report;

import sis.studentinfo.Student;
import sis.studentinfo.CourseSession;
import sis.util.StringUtil;

public class RosterReporter {

//    public static final String NEWLINE = System.getProperty("line.separator");
    public static final String ROSTER_REPORT_HEADER = "Student" + StringUtil.NEWLINE + "-" + StringUtil.NEWLINE;
    public static final String ROSTER_REPORT_FOOTER = StringUtil.NEWLINE + "# students =";

    private CourseSession session;

    public RosterReporter(CourseSession session) {

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
        writeHeader(buffer);
        writeBody(buffer);
        writeFooter(buffer);

        return buffer.toString();
    }

    void writeHeader(StringBuilder buffer) {
        buffer.append(ROSTER_REPORT_HEADER);
    }

    void writeBody(StringBuilder buffer) {
        for (Student student : session.getAllStudents()) {
            buffer.append(student.getName());
            buffer.append(StringUtil.NEWLINE);
        }
    }

    void writeFooter(StringBuilder buffer) {
        buffer.append(ROSTER_REPORT_FOOTER + session.getAllStudents().size() + StringUtil.NEWLINE);
    }
}
