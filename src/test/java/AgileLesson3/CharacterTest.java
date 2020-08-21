package AgileLesson3;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    public void testWhitespace() {

        assertEquals(true, java.lang.Character.isWhitespace(' '));


        assertTrue(java.lang.Character.isWhitespace(' '));
        assertTrue(java.lang.Character.isWhitespace('\n'));
        assertTrue(java.lang.Character.isWhitespace('\t'));
        assertTrue(java.lang.Character.isWhitespace('\r'));

        assertFalse(java.lang.Character.isWhitespace('a'));
        assertFalse(java.lang.Character.isWhitespace('B'));
    }

    @Test
    public void testJavaIdentifierStart() {
        char[] acceptableChars = new char[]{
                'C', '$', 'l', '\u2161', '_'
        };

        for (char ch : acceptableChars) {
            assertTrue(java.lang.Character.isJavaIdentifierStart(ch));
        }

        char[] unacceptableChars = new char[]{
                '5', '^', '*', '\\', '\t'
        };

        for (char ch : unacceptableChars) {
            assertFalse(java.lang.Character.isJavaIdentifierStart(ch));
        }
    }
}
