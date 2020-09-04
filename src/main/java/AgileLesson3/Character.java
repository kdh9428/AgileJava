package AgileLesson3;

public class Character {

    public static boolean isWhitespace(char character) {

        if (character == ' '){
            return true;
        }else if (character == '\n'){
            return true;
        }else if (character == '\t'){
            return true;
        }else if (character == '\r'){
            return true;
        }else{
            return false;
        }
    }
}
