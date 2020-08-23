package pieces;

public class Piece {

    private final String color;
    private char initials;

    public static final String WHITE = "white";
    public static final String BLACK = "black";

    private Piece(String color) {
        this.color = color;
        createColor();
    }

    private void createColor() {
        if (color == "white") {
            this.initials = 'p';
        } else if (color == "black") {
            this.initials = 'P';
        }
    }

    public static Piece createPiece(String color){
        return new Piece(color);
    }


    public String getColor() {
        return color;
    }

    public char getInitials() {
        return initials;
    }

    public void setInitials(char initials) {
        this.initials = initials;
    }
}
