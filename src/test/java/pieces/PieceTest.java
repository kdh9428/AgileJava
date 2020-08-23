package pieces;

import chess.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    public void testCreate() {

        final String WHITE = "white";
        final String BLACK = "black";

        Piece piece = Piece.createPiece(WHITE);
        assertEquals(WHITE, piece.getColor());

        Piece piece1 = Piece.createPiece(BLACK);
        assertEquals(BLACK, piece1.getColor());

        Board board = new Board();
        board.initialize();

        assertEquals(16, board.getNumberOfPawns());


        StringBuilder whiteLocation = new StringBuilder();
        StringBuilder blackLocation = new StringBuilder();


        for (int i = 0; i < Board.BOARD_ROW; i++) {
            blackLocation.append(board.getPawn(i + Board.BOARD_ROW).getInitials());
            whiteLocation.append(board.getPawn(i + (Board.BOARD_ROW * 6)).getInitials());
        }

        assertEquals(whiteLocation.toString(),"pppppppp");
        assertEquals(blackLocation.toString(),"PPPPPPPP");
    }

    @Test
    public void 전역_상수() {

        Piece piece = Piece.createPiece("white");
        String defaultColor = Piece.WHITE;
        assertEquals(defaultColor, piece.getColor());
    }

    @Test
    public void BlackAndWhitePawn() {

        Piece blackPiece = Piece.createPiece(Piece.BLACK);
        assertEquals("black", blackPiece.getColor());
        assertEquals('P', blackPiece.getInitials());

        Piece whitePiece =Piece.createPiece(Piece.WHITE);
        assertEquals("white", whitePiece.getColor());
        assertEquals('p', whitePiece.getInitials());

    }
}
