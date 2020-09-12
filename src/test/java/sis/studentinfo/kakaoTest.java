package sis.studentinfo;

import org.junit.jupiter.api.Test;

public class kakaoTest {

    public String test(String new_id) {

        String answer = "";
        String s = new_id.toLowerCase();

        String match = "[^-_.0-9a-z\\s]";
        s = s.replaceAll(match, "");

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);

            if (i < s.length() - 1 && check == '.' && check == s.charAt(i + 1)) {

                stringBuffer.append("");
            } else {
                stringBuffer.append(check);
            }

        }
        if (stringBuffer.charAt(0) == '.')
            stringBuffer.replace(0, 1, "");

        if (stringBuffer.equals(null) || stringBuffer.length() == 0)
            stringBuffer.append("a");

        if (stringBuffer.length() >= 16)
            stringBuffer.replace(15, stringBuffer.length(), "");

        if (stringBuffer.charAt(stringBuffer.length() - 1) == '.')
            stringBuffer.replace(stringBuffer.length() - 1, stringBuffer.length(), "");

        if (stringBuffer.length() <= 2) {
            for (int i = stringBuffer.length(); i < 3; i++) {
                char appendChar = stringBuffer.charAt(stringBuffer.length() - 1);
                stringBuffer.append(appendChar);
            }
        }
        answer = stringBuffer.toString();
        return answer;
    }


    @Test
    public void tests() {
        String test = test("...!@BaT#*..y.abcdefghijklm");
        System.out.println(test);
    }

    @Test
    public String[] 프로그래밍2(String[] orders, int[] course) {

        String[] answer = {};


        return answer;

    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];


        String[][] infoSplit = querySplit(info);


        StringBuilder queryBuffer = new StringBuilder();
        String[] andRemoval = new String[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] ands = query[i].split("and ");

            for (String a : ands) {
                queryBuffer = queryBuffer.append(a);
            }
            andRemoval[i] = queryBuffer.toString();
            System.out.println(queryBuffer);
            queryBuffer.delete(0, queryBuffer.length());
        }

        String[][] querySplits = querySplit(andRemoval);

        int count = 0;
        for (int i = 0; i < querySplits.length; i++) {

            for (int j = 0; j < infoSplit.length; j++) {
                if (querySplits[i][0].equals(infoSplit[j][0]) || querySplits[i][0].equals("-")) {
                    if (querySplits[i][1].equals(infoSplit[j][1]) || querySplits[i][1].equals("-"))
                        if (querySplits[i][2].equals(infoSplit[j][2]) || querySplits[i][2].equals("-"))
                            if (querySplits[i][3].equals(infoSplit[j][3]) || querySplits[i][3].equals("-"))
                                if (Integer.parseInt(querySplits[i][4]) <= Integer.parseInt(infoSplit[j][4]) || querySplits[i][4].equals("-"))
                                    ++count;
                }
            }
            answer[i] = count;
            count = 0;
        }

        return answer;
    }

    public boolean secondArray(String[] querySplits, String[][] infoSplit) {
        for (int i = 0; i < infoSplit.length; i++) {
            if (querySplits[1] == infoSplit[i][1] || infoSplit[i][1] == "-") {

            }
        }

        return true;
    }


    public String[][] querySplit(String[] query) {

        String[][] splits = new String[query.length][5];

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < query.length; i++) {

            String splitString = query[i];
            String[] strings = splitString.split(" ");

            for (int j = 0; j < strings.length; j++) {

                splits[i][j] = strings[j];
            }
        }

        return splits;
    }

    @Test
    public void 프로그래밍3() {

        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        String[] test = {"java and backend and junior and pizza 100"};
        String[] test1 = {"- and - and - and - -"};
        int[] solution = solution(info, query);

        for (int a : solution) {
            System.out.println(a);
        }
    }

}
