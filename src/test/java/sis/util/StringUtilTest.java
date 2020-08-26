package sis.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    public void 새줄_문자(){
        String str = "ABCD";
        assertEquals(str + StringUtil.NEWLINE, StringUtil.appendNewLine(str));
    }

}