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

        Piece piece = Piece.createPiece(WHITE, Piece.PAWN);
        assertEquals(WHITE, piece.getColor());

        Piece piece1 = Piece.createPiece(BLACK, Piece.PAWN);
        assertEquals(BLACK, piece1.getColor());

        Board board = new Board();
        board.initialize();

        assertEquals(16, board.getNumberOfPawns());


        StringBuilder whiteLocation = new StringBuilder();
        StringBuilder blackLocation = new StringBuilder();


        for (int i = 0; i < Board.BOARD_ROW; i++) {
            blackLocation.append(board.getPieces(i + Board.BOARD_ROW).getInitials());
            whiteLocation.append(board.getPieces(i + (Board.BOARD_ROW * 6)).getInitials());
        }

        assertEquals(whiteLocation.toString(), "pppppppp");
        assertEquals(blackLocation.toString(), "PPPPPPPP");
    }

    @Test
    public void 전역_상수() {

        Piece piece = Piece.createPiece("white", Piece.PAWN);
        String defaultColor = Piece.WHITE;
        assertEquals(defaultColor, piece.getColor());
    }

    @Test
    public void BlackAndWhitePawn() {

        Piece blackPiece = Piece.createPiece(Piece.BLACK, Piece.PAWN);
        assertEquals("black", blackPiece.getColor());
        assertEquals('P', blackPiece.getInitials());

        Piece whitePiece = Piece.createPiece(Piece.WHITE, Piece.PAWN);
        assertEquals("white", whitePiece.getColor());
        assertEquals('p', whitePiece.getInitials());

    }

    @Test
    public void 체스_말_생성_테스트() {
        Piece whitePiece = Piece.createPiece(Piece.WHITE, Piece.PAWN);
        assertEquals('P', whitePiece.getInitials());

        Piece blackPiece = Piece.createPiece(Piece.BLACK, Piece.PAWN);
        assertEquals('p', blackPiece.getInitials());
    }

    @Test
    public void testColor(){
        Piece whiteBishop = Piece.createPiece(Piece.WHITE, Piece.BISHOP);
        assertTrue(whiteBishop.isWhite(), "흰색이 나와야 합니다.");

        Piece blackKing = Piece.createPiece(Piece.BLACK, Piece.KING);
        assertTrue(blackKing.isBlack(), "검정색이 나와야 합니다.");
    }

    @Test
    public void testPieceCount(){

        Board board = new Board();

        board.initialize();

        assertEquals(16,Piece.getWhitePieceCount());
        assertEquals(16,Piece.getBlackPieceCount());

    }
}
