package AgileLesson7;

import java.util.List;

public class lesson7 {

    private int fib(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;

        int fib = 0;
        int nextFib = 1;
        int index = 0;
        int temp;
        do {
            temp = fib + nextFib;
            nextFib = temp;
        } while (++index < x);
        return fib;
    }

    public int fibRecursive(int x) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;

        return fibRecursive(x - 1) + fibRecursive(x - 2);
    }


    String sequenceUsingDo(int start, int stop) {
        StringBuilder builder = new StringBuilder();
        int i = start;
        do {
            if (i > start)
                builder.append(',');
            builder.append(i);
        } while (++i <= stop);
        return builder.toString();
    }

    String sequenceUsingFor(int start, int stop) {
        StringBuilder builder = new StringBuilder();
        for (int i = start; i <= stop; i++) {
            if (i > start)
                builder.append(',');
            builder.append(i);
        }
        return builder.toString();
    }

    String sequenceUsingWhile(int start, int stop) {
        StringBuilder builder = new StringBuilder();
        int i = start;
        while (i <= stop) {
            if (i > start)
                builder.append(',');
            builder.append(i);
            i++;
        }
        return builder.toString();
    }


    public String endTrim(String source) {

        System.out.println("source  : " + source);
        int i = source.length();

        System.out.println("i : " + i);
//        System.out.println(source + ", " + i + ", " + source.charAt(0));
        while (i > 0) {

            i--;

            if (source.charAt(i) != ' ') {
                i++;
                break;
            }
        }
        System.out.println(i);

        return source.substring(0, i);
    }

    public static boolean found(List<List<String>> table, String target) {
        boolean found = false;
        a:
        for (List<String> row : table) {
            for (String value : row) {
                if (value.equals(target)) {
                    found = true;
                    break a;
                }
            }
        }
        return found;
    }
}
