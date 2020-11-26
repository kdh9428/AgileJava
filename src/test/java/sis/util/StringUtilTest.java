package sis.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    public void 새줄_문자() {
        String str = "ABCD";
        assertEquals(str + StringUtil.NEWLINE, StringUtil.appendNewLine(str));
    }

    private static final String TEXT = "this is it, isnt it";

    @Test
    public void 문자열_비교_테스트(){
        assertEquals(true, TEXT.regionMatches(true, 2, "is", 0, 2));
    }

    @Test
    public void testOccurrencesOne() {
        assertEquals(1, StringUtil.occurrences(TEXT, "his"));
    }

    @Test
    public void testOccurrencesNone() {
        assertEquals(0, StringUtil.occurrences(TEXT, "smelt"));
    }

    @Test
    public void testOccurrencesMany() {
        assertEquals(3, StringUtil.occurrences(TEXT, "is"));
        assertEquals(2, StringUtil.occurrences(TEXT, "it"));
    }

    @Test
    public void testOccurrencesSearchStringTooLarge() {
        assertEquals(0, StringUtil.occurrences(TEXT, TEXT + "sdfas"));
    }


}