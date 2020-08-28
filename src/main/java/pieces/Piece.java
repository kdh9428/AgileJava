package pieces;


public class Piece {

    public enum Color {
        WHITE("white"), BLACK("black"), NONE("none");

        String stringColor;

        Color(String stringColor) {
            this.stringColor = stringColor;
        }
    }

    public enum TypesOfChessPiece {
        PAWN('p'), KNIGHT('n'), ROOK('r'), BISHOP('b'), QUEEN('q'), KING('k'), NO_PIECE('.');

        char initials;

        TypesOfChessPiece(char initials) {
            this.initials = initials;
        }
    }

    private final String color;
    private char representation;
    private TypesOfChessPiece type;
    private static int whitePieceCount;
    private static int blackPieceCount;


//    public static final String WHITE = "white";
//    public static final String BLACK = "black";

//    public static final String PAWN = "pawn";
//    public static final String KNIGHT = "knight";
//    public static final String ROOK = "rook";
//    public static final String BISHOP = "bishop";
//    public static final String QUEEN = "queen";
//    public static final String KING = "king";

    private Piece(Color color, TypesOfChessPiece chessPiece) {

        this.color = color.stringColor;
        this.representation = chessPiece.initials;
        this.type = chessPiece;

        if (color == Color.WHITE) {
            this.representation = chessPiece.initials;
        } else {
            this.representation = Character.toUpperCase(chessPiece.initials);
        }
    }

    public static Piece createPiece(Color color, TypesOfChessPiece chessPiece) {

        if (color == Color.BLACK) {
            addBlackPieceCount();
        } else {
            addWhitePieceCount();
        }
        return new Piece(color, chessPiece);
    }

    public static Piece createWhite(TypesOfChessPiece type) {
        return createPiece(Color.WHITE, type);
    }

    public static Piece createBlack(TypesOfChessPiece type) {
        return createPiece(Color.BLACK, type);
    }

    public static Piece noPiece() {
        return new Piece(Color.NONE, TypesOfChessPiece.NO_PIECE);
    }


    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
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
        return color == Color.BLACK.stringColor;
    }

    public boolean isWhite() {
        return color == Color.WHITE.stringColor;
    }

    public TypesOfChessPiece getType() {
        return type;
    }

    public void setType(TypesOfChessPiece type) {
        this.type = type;
    }

}
