package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void 체스판_초기화() {
        Board board = new Board();
    }

    @Test
    public void 장기말_추가() {
        Piece piece = Piece.createPiece(Piece.BLACK);
        board.add(piece);

        assertEquals(1, board.getNumberOfPawns());
        assertEquals(piece, board.getPawn(0));

        Piece whitePiece = Piece.createPiece(Piece.WHITE);
        board.add(whitePiece);
        assertEquals(2, board.getNumberOfPawns());
        assertEquals(whitePiece, board.getPawn(1));
    }

    @Test
    public void Pawn_이외의_객체_불가() {

//        board.add(new Integer("7"));
    }
}