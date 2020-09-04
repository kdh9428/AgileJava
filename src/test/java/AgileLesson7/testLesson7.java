package AgileLesson7;

import org.junit.jupiter.api.Test;
import sis.studentinfo.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class testLesson7 {


    @Test
    public void for_루프_다중_초기화_갱신() {
        int charsCount = Student.countChars("asbdbbb", 'b');
        System.out.println(charsCount);

        assertFalse(Student.isPalindrome("abcdef"));
        assertFalse(Student.isPalindrome("abccda"));
        assertTrue(Student.isPalindrome("abccba"));
        assertFalse(Student.isPalindrome("abcxba"));
        assertTrue(Student.isPalindrome("a"));
        assertTrue(Student.isPalindrome("aa"));
        assertFalse(Student.isPalindrome("ab"));
        assertTrue(Student.isPalindrome(""));
        assertTrue(Student.isPalindrome("aaa"));
        assertTrue(Student.isPalindrome("aba"));
        assertTrue(Student.isPalindrome("abbba"));
        assertTrue(Student.isPalindrome("abba"));
        assertFalse(Student.isPalindrome("abbaa"));
        assertFalse(Student.isPalindrome("abcda"));
    }

    @Test
    public void testFibonacci() {

        lesson7 less = new lesson7();

//        assertEquals(0, less.fib(0));
//        assertEquals(0, less.fibRecursive(0));
//        assertEquals(1, less.fibRecursive(1));
//        assertEquals(1, less.fibRecursive(2));
        assertEquals(2, less.fibRecursive(3));
//        assertEquals(3, less.fibRecursive(4));
//        assertEquals(5, less.fibRecursive(5));
//        assertEquals(8, less.fibRecursive(6));
    }

    @Test
    public void testCommas() {

        lesson7 less = new lesson7();
        String sequence = "1,2,3,4,5";
        assertEquals(sequence, less.sequenceUsingDo(1, 5));
        assertEquals(sequence, less.sequenceUsingFor(1, 5));
        assertEquals(sequence, less.sequenceUsingWhile(1, 5));

        sequence = "8";
        assertEquals(sequence, less.sequenceUsingDo(8, 8));
        assertEquals(sequence, less.sequenceUsingFor(8, 8));
        assertEquals(sequence, less.sequenceUsingWhile(8, 8));
    }


    @Test
    public void testEndTrim() {
        lesson7 less = new lesson7();

        assertEquals("", less.endTrim(""));
        assertEquals("  x", less.endTrim("  x  "));
        assertEquals("xaxa", less.endTrim("xaxa "));
        assertEquals("Y", less.endTrim("Y "));
        assertEquals("", less.endTrim(" "));
        assertEquals("xxx", less.endTrim("xxx       "));

    }

    @Test
    public void testLabeledBreak() {
        List<List<String>> table = new ArrayList<>();

        List<String> row1 = new ArrayList<>();
        row1.add("5");
        row1.add("2");

        List<String> row2 = new ArrayList<>();
        row2.add("3");
        row2.add("4");

        table.add(row1);
        table.add(row2);

        assertTrue(lesson7.found(table, "3"));
        assertTrue(lesson7.found(table, "4"));
        assertFalse(lesson7.found(table, "8"));
    }

    @Test
    public void testCasting(){
        List students = new ArrayList();
        students.add(new Student("a"));
        students.add(new Student("b"));

        List name = new ArrayList();

        Iterator it = students.iterator();

        while (it.hasNext()){
            Student student = (Student) it.next();
            name.add(student.getLastName());

        }

        assertEquals("a", name.get(0));
        assertEquals("b", name.get(1));



    }
}