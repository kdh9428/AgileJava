package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.Piece;
import sis.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void 체스판_생성() {
        Board board = new Board();
    }

    @Test
    public void 장기말_추가() {
//        board.initialize();
        Piece piece = Piece.createPiece(Piece.BLACK, Piece.PAWN);
        board.addPieces(piece);

        assertEquals(1, board.getNumberOfPawns());
        assertEquals(piece, board.getPieces(0));

        Piece whitePiece = Piece.createPiece(Piece.WHITE, Piece.PAWN);
        board.addPieces(whitePiece);
        assertEquals(2, board.getNumberOfPawns());
        assertEquals(whitePiece, board.getPieces(1));
    }

    @Test
    public void Pawn_이외의_객체_불가() {

//        board.add(new Integer("7"));
    }

    @Test
    public void 흰색_체스말_생성() {

        Piece pawnPiece = Piece.createPiece(Piece.WHITE, Piece.PAWN);
        assertEquals("white", pawnPiece.getColor());
        assertEquals('P', pawnPiece.getInitials());

        Piece knightPiece = Piece.createPiece(Piece.WHITE, Piece.KNIGHT);
        assertEquals("white", knightPiece.getColor());
        assertEquals('N', knightPiece.getInitials());

        Piece rookPiece = Piece.createPiece(Piece.WHITE, Piece.ROOK);
        assertEquals("white", rookPiece.getColor());
        assertEquals('R', rookPiece.getInitials());

        Piece bishopPiece = Piece.createPiece(Piece.WHITE, Piece.BISHOP);
        assertEquals("white", bishopPiece.getColor());
        assertEquals('B', bishopPiece.getInitials());

        Piece queenPiece = Piece.createPiece(Piece.WHITE, Piece.QUEEN);
        assertEquals("white", queenPiece.getColor());
        assertEquals('Q', queenPiece.getInitials());

        Piece kingPiece = Piece.createPiece(Piece.WHITE, Piece.KING);
        assertEquals("white", kingPiece.getColor());
        assertEquals('K', kingPiece.getInitials());
    }

    @Test
    public void 검은색_체스말_생성(){
        Piece pawnPiece = Piece.createPiece(Piece.BLACK, Piece.PAWN);
        assertEquals("black", pawnPiece.getColor());
        assertEquals('p', pawnPiece.getInitials());

        Piece knightPiece = Piece.createPiece(Piece.BLACK, Piece.KNIGHT);
        assertEquals("black", knightPiece.getColor());
        assertEquals('n', knightPiece.getInitials());

        Piece rookPiece = Piece.createPiece(Piece.BLACK, Piece.ROOK);
        assertEquals("black", rookPiece.getColor());
        assertEquals('r', rookPiece.getInitials());

        Piece bishopPiece = Piece.createPiece(Piece.BLACK, Piece.BISHOP);
        assertEquals("black", bishopPiece.getColor());
        assertEquals('b', bishopPiece.getInitials());

        Piece queenPiece = Piece.createPiece(Piece.BLACK, Piece.QUEEN);
        assertEquals("black", queenPiece.getColor());
        assertEquals('q', queenPiece.getInitials());

        Piece kingPiece = Piece.createPiece(Piece.BLACK, Piece.KING);
        assertEquals("black", kingPiece.getColor());
        assertEquals('k', kingPiece.getInitials());
    }

    @Test
    public void testCreate() {
        board.initialize();

        assertEquals(32,board.pieceCount());

        String blankRank = StringUtil.appendNewLine("........");

        assertEquals(
                StringUtil.appendNewLine("RNBQKBNR") +
                        StringUtil.appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        StringUtil.appendNewLine("ppppppp") +
                        StringUtil.appendNewLine("rnbqkbnr"),
                board.print());
    }

    @Test
    public void testPrint(){
        Board board = new Board();
        board.initialize();
        board.print();
    }
}