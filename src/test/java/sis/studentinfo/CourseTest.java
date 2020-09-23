package sis.studentinfo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;
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

        //apples & oranges
        assertFalse(courseA.equals("CMSC-120"));

//        assertSame(courseA, courseAPrime);

//        List<Course> list = new ArrayList<>();
//        list.add(courseA);
//        assertTrue(list.contains(courseAPrime));

        Map<Course, String> map = new HashMap<>();
        map.put(courseA, "");
        assertTrue(map.containsKey(courseAPrime));

        Map<Integer, String> asd = new HashMap<>();
    }

    @Test
    public void testHashCode() {
        Course courseA = new Course("NURS", "201");
        Course courseAPrime = new Course("NURS", "201");

//        Map<Course, String> map = new HashMap<>();
//        map.put(courseA,"");
//        assertTrue(map.containsKey(courseAPrime));

        Map<String, String> map = new Hashtable<>();

        map.put("aa", "Bb");

        String aa = map.get("aa");
        System.out.println(aa + " ++++++ ");
        assertEquals(courseA.hashCode(), courseAPrime.hashCode());

        //consistency
        assertEquals(courseA.hashCode(), courseA.hashCode());
    }

    @Test
    public void testHashCodePerformance() {
        final int count = 10000;
        long start = System.currentTimeMillis();
        Map<Course, String> map = new HashMap<>();

        for (int i = 0; i < count; i++) {
            Course course = new Course("C" + i, "" + i);
            map.put(course, "");
        }
        long stop = System.currentTimeMillis();
        long elapsed = stop - start;
        final long arbitraryThreshold = 200;
        assertTrue( elapsed < arbitraryThreshold, "elapsed time = " + elapsed);
    }
}