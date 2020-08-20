package AgileLesson2;

import AgileLesson1.StudentTest;
import AgileLesson3.RosterReporter;
import AgileLesson3.RosterReporterTest;
import chess.BoardTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({StudentTest.class, CourseSessionTest.class, BoardTest.class, RosterReporterTest.class})
public class AllTests {

}
