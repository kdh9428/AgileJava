package pieces;

public class Piece {

    private final String color;
    private char initials;
    private static int whitePieceCount;
    private static int blackPieceCount;

    public static final String WHITE = "white";
    public static final String BLACK = "black";

    public static final String PAWN = "pawn";
    public static final String KNIGHT = "knight";
    public static final String ROOK = "rook";
    public static final String BISHOP = "bishop";
    public static final String QUEEN = "queen";
    public static final String KING = "king";


    private Piece(String color, String chessPiece) {
        this.color = color;

        if (color == "white")
            if (chessPiece == KNIGHT)
                this.initials = 'N';
            else
                this.initials = Character.toUpperCase(chessPiece.charAt(0));
        else if (chessPiece == KNIGHT)
            this.initials = 'n';
        else
            this.initials = chessPiece.charAt(0);

    }

//    private void createColor() {
//        if (color == "white") {
//            this.initials = 'p';
//        } else if (color == "black") {
//            this.initials = 'P';
//        }
//    }

    public static Piece createPiece(String color, String chessPiece) {

        if (color == Piece.BLACK)
            addBlackPieceCount();
        else if (color == Piece.WHITE)
            addWhitePieceCount();

        return new Piece(color, chessPiece);
    }

    public String getColor() {
        return color;
    }

    public char getInitials() {
        return initials;
    }

    public static void addWhitePieceCount() {
        whitePieceCount++;
    }

    public static void addBlackPieceCount() {
        blackPieceCount++;
    }

    public static int getWhitePieceCount() {
        return whitePieceCount;
    }

    public static int getBlackPieceCount() {
        return blackPieceCount;
    }

    public boolean isBlack() {
        return color.equals(BLACK);
    }

    public boolean isWhite() {
        return color.equals(WHITE);
    }
}
