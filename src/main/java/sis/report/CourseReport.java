package sis.report;

import sis.studentinfo.CourseSession;
import sis.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;

public class CourseReport {


    private ArrayList<CourseSession> sessions = new ArrayList<>();

    public void add(CourseSession session) {
        sessions.add(session);
    }

    public String text() {

        Collections.sort(sessions);

        StringBuilder builder = new StringBuilder();
        for (CourseSession session : sessions) {
            builder.append(session.getDepartment() + " " + session.getNumber() + StringUtil.NEWLINE);
        }

        return builder.toString();
    }
}
