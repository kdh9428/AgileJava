package pieces;

import chess.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PieceTest {

    @Test
    public void testCreate() {

        final String WHITE = "white";
        final String BLACK = "black";

        Piece whitePiece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.PAWN);
        assertEquals(WHITE, whitePiece.getColor());

        Piece blackPiece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.PAWN);
        assertEquals(BLACK, blackPiece.getColor());

        Board board = new Board();
        board.initialize();

        assertEquals(32, board.getNumberOfPawns());


        StringBuilder whiteLocation = new StringBuilder();
        StringBuilder blackLocation = new StringBuilder();


        for (int i = 0; i < Board.BOARD_ROW; i++) {
            blackLocation.append(board.getPieces(i + Board.BOARD_ROW).getRepresentation());
            whiteLocation.append(board.getPieces(i + (Board.BOARD_ROW * 2)).getRepresentation());
        }

        assertEquals(whiteLocation.toString(), "pppppppp");
        assertEquals(blackLocation.toString(), "PPPPPPPP");
    }

    @Test
    public void testCrestePiece() {
        verifyCreation(Piece.createWhite(Piece.TypesOfChessPiece.PAWN), Piece.createBlack(Piece.TypesOfChessPiece.PAWN), Piece.TypesOfChessPiece.PAWN, Piece.TypesOfChessPiece.PAWN.initials);
        verifyCreation(Piece.createWhite(Piece.TypesOfChessPiece.ROOK), Piece.createBlack(Piece.TypesOfChessPiece.ROOK), Piece.TypesOfChessPiece.ROOK, Piece.TypesOfChessPiece.ROOK.initials);
        verifyCreation(Piece.createWhite(Piece.TypesOfChessPiece.KNIGHT), Piece.createBlack(Piece.TypesOfChessPiece.KNIGHT), Piece.TypesOfChessPiece.KNIGHT, Piece.TypesOfChessPiece.KNIGHT.initials);
        verifyCreation(Piece.createWhite(Piece.TypesOfChessPiece.BISHOP), Piece.createBlack(Piece.TypesOfChessPiece.BISHOP), Piece.TypesOfChessPiece.BISHOP, Piece.TypesOfChessPiece.BISHOP.initials);
        verifyCreation(Piece.createWhite(Piece.TypesOfChessPiece.QUEEN), Piece.createBlack(Piece.TypesOfChessPiece.QUEEN), Piece.TypesOfChessPiece.QUEEN, Piece.TypesOfChessPiece.QUEEN.initials);
        verifyCreation(Piece.createWhite(Piece.TypesOfChessPiece.KING), Piece.createBlack(Piece.TypesOfChessPiece.KING), Piece.TypesOfChessPiece.KING, Piece.TypesOfChessPiece.KING.initials);

        Piece blank = Piece.noPiece();

        assertEquals('.', blank.getRepresentation());
        assertEquals(Piece.TypesOfChessPiece.NO_PIECE, blank.getType());
    }

    private void verifyCreation(Piece whitePiece, Piece blackPiece, Piece.TypesOfChessPiece type, char representation) {

        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());
        assertEquals(Character.toUpperCase(representation), whitePiece.getRepresentation());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
        assertEquals(representation, blackPiece.getRepresentation());

    }

    @Test
    public void 전역_상수() {

        Piece piece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.PAWN);
        String defaultColor = Piece.Color.WHITE.stringColor;
        assertEquals(defaultColor, piece.getColor());
    }

    @Test
    public void BlackAndWhitePawn() {

        Piece blackPiece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.PAWN);
        assertEquals("black", blackPiece.getColor());
        assertEquals('p', blackPiece.getRepresentation());

        Piece whitePiece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.PAWN);
        assertEquals("white", whitePiece.getColor());
        assertEquals('P', whitePiece.getRepresentation());

    }

    @Test
    public void 체스_말_생성_테스트() {
        Piece whitePiece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.KING);
        assertEquals('K', whitePiece.getRepresentation());

        Piece blackPiece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.KNIGHT);
        assertEquals('n', blackPiece.getRepresentation());
    }

    @Test
    public void testColor() {
        Piece whiteBishop = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.BISHOP);
        assertTrue(whiteBishop.isWhite(), "흰색이 나와야 합니다.");

        Piece blackKing = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.KING);
        assertTrue(blackKing.isBlack(), "검정색이 나와야 합니다.");
    }

    @Test
    public void testPieceCount() {

        Board board = new Board();

        board.initialize();

        assertEquals(16, Piece.getWhitePieceCount());
        assertEquals(16, Piece.getBlackPieceCount());

    }

    @Test
    public void testP() {
        Piece piece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.KNIGHT);

        System.out.println(Piece.Color.BLACK);
        System.out.println(Piece.Color.WHITE);
    }
}
