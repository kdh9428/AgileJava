package sis.util;

public class StringUtil {

    public static final String NEWLINE = System.lineSeparator();

    private StringUtil() {
    }

    public static String appendNewLine(String str) {
        return str + NEWLINE;
    }

    public static int occurrences(String string, String subString) {
        int occurrences = 0;
        int length = subString.length();
        final boolean ignoreCase = true;

        for (int i = 0; i < string.length() - subString.length() + 1; i++) {
            if (string.regionMatches(ignoreCase, i, subString, 0, length))
                occurrences++;
        }
        return occurrences;
    }
}
