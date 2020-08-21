package sis.studentinfo;

import sis.report.RosterReporterTest;
import chess.BoardTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({StudentTest.class, CourseSessionTest.class, BoardTest.class, DateUtilTest.class})
public class AllTests {

}
