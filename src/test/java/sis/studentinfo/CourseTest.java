package sis.studentinfo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    public void testCreate() {
        Course course = new Course("CMSC", "120");
        assertEquals("CMSC", course.getDepartment());
        assertEquals("120", course.getNumber());
    }

    @Test
    public void testEquality() {
        Course courseA = new Course("NURS", "201");
        Course courseAPrime = new Course("NURS", "201");
        assertEquals(courseA, courseAPrime);

        Course courseB = new Course("ARTH", "300");

        assertFalse(courseA.equals(courseB));

        //reflexivity
        assertEquals(courseA, courseA);

        //transitivity
        Course courseAPrime2 = new Course("NURS", "201");
        assertEquals(courseA, courseAPrime);
        assertEquals(courseAPrime, courseAPrime2);
        assertEquals(courseA, courseAPrime2);

        //symmetry
        assertEquals(courseAPrime, courseA);

        //consistency
        assertEquals(courseA, courseAPrime);

        //comparison to null
        assertFalse(courseA.equals(null));

//        assertSame(courseA, courseAPrime);

//        List<Course> list = new ArrayList<>();
//        list.add(courseA);
//        assertTrue(list.contains(courseAPrime));

        Map<Course, String> map = new HashMap<>();
        map.put(courseA,"");
        assertTrue(map.containsKey(courseAPrime));



    }
}