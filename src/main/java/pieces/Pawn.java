package pieces;

public class Pawn {

    private final String color;

    public static final String WHITE = "white";
    public static final String BLACK = "black";

    public Pawn() {
        this("white");
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
