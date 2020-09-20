package sis.report;

import org.junit.jupiter.api.Test;
import sis.studentinfo.Course;
import sis.studentinfo.CourseSession;
import sis.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CourseReportTest {

    @Test
    public void testReport() {
        Date date = new Date();

        CourseReport report = new CourseReport();
//        report.add(CourseSession.create("ENGL", "101", date));
//        report.add(CourseSession.create("CZEC", "200", date));
//        report.add(CourseSession.create("ITAL", "401", date));
//        report.add(CourseSession.create("CZEC", "220", date));
//        report.add(CourseSession.create("ITAL", "330", date));

        report.add(create("ENGL", "101", date));
        report.add(create("CZEC", "200", date));
        report.add(create("ITAL", "401", date));
        report.add(create("CZEC", "220", date));
        report.add(create("ITAL", "330", date));

//        assertEquals("ENGL 101" + StringUtil.NEWLINE +
//                "CZEC 200" + StringUtil.NEWLINE +
//                "ITAL 401" + StringUtil.NEWLINE, report.text()
//        );

        //보고서 정렬 확인
        assertEquals("CZEC 200" + StringUtil.NEWLINE +
                "CZEC 220" + StringUtil.NEWLINE +
                "ENGL 101" + StringUtil.NEWLINE +
                "ITAL 330" + StringUtil.NEWLINE +
                "ITAL 401" + StringUtil.NEWLINE, report.text()
        );
    }

    private CourseSession create(String name, String number, Date date) {
        return (CourseSession) CourseSession.create(new Course(name, number), date);
    }

    @Test
    public void testSortStringsInPlace() {

        ArrayList<String> list = new ArrayList<>();
        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");
        Collections.sort(list);
        assertEquals("Boyle", list.get(0));
        assertEquals("Camus", list.get(1));
        assertEquals("Heller", list.get(2));
        assertEquals("Kafka", list.get(3));

    }

    @Test
    public void testSortStringsInNewList() {
        ArrayList<String> list = new ArrayList<>();

        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");

        ArrayList<String> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        assertEquals("Boyle", sortedList.get(0));
        assertEquals("Camus", sortedList.get(1));
        assertEquals("Heller", sortedList.get(2));
        assertEquals("Kafka", sortedList.get(3));

        sortedList.stream().forEach(System.out::println);
        list.stream().forEach(System.out::println);

        assertEquals("Heller", list.get(0));
        assertEquals("Kafka", list.get(1));
        assertEquals("Camus", list.get(2));
        assertEquals("Boyle", list.get(3));

    }

    @Test
    public void testStringCompareTo() {
        assertTrue("A".compareTo("B") < 0);
        System.out.println("A".compareTo("B"));
        assertEquals(0, "A".compareTo("A"));
        assertTrue("B".compareTo("A") > 0);
        System.out.println("B".compareTo("A"));
    }

    @Test
    public void testComparable() {
        final Date date = new Date();

//        CourseSession sessionA = CourseSession.create("CMSC", "101", date);
//        CourseSession sessionB = CourseSession.create("ENGL", "101", date);
        CourseSession sessionA = (CourseSession) CourseSession.create(new Course("CMSC", "101"), date);
        CourseSession sessionB = (CourseSession) CourseSession.create(new Course("ENGL", "101"), date);

        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);

//        CourseSession sessionC = CourseSession.create("CMSC", "101", date);
        CourseSession sessionC = (CourseSession) CourseSession.create(new Course("CMSC", "101"), date);
        assertEquals(0, sessionA.compareTo(sessionC));

//        CourseSession sessionD = CourseSession.create("CMSC", "210", date);
        CourseSession sessionD = (CourseSession) CourseSession.create(new Course("CMSC", "210"), date);
        assertTrue(sessionC.compareTo(sessionD) < 0);
        assertTrue(sessionD.compareTo(sessionC) > 0);
    }
}