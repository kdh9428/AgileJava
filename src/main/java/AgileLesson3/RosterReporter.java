package AgileLesson3;

import AgileLesson1.Student;
import AgileLesson2.CourseSession;

public class RosterReporter {

    public static final String NEWLINE = System.getProperty("line.separator");
    public static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "-" + NEWLINE;
    public static final String ROSTER_REPORT_FOOTER = NEWLINE + "# students =";

    private CourseSession session;

    public RosterReporter(CourseSession session) {

        this.session = session;
    }

    public String getReport() {

        StringBuilder buffer = new StringBuilder();
        buffer.append(ROSTER_REPORT_HEADER);


//        Student student = students.get(0);
//        buffer.append(student.getName());
//        buffer.append(NEWLINE);
//
//        student = students.get(1);
//        buffer.append(student.getName());
//        buffer.append(NEWLINE);

        for (Student student : session.getAllStudents()){
            buffer.append(student.getName());
            buffer.append(NEWLINE);
        }

        buffer.append(ROSTER_REPORT_FOOTER + session.getAllStudents().size() + NEWLINE);

        return buffer.toString();
    }
}
