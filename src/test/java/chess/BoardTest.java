package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.Piece;
import sis.util.StringUtil;

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
        Piece piece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.PAWN);
        board.addPieces(piece);

        assertEquals(1, board.getNumberOfPawns());
        assertEquals(piece, board.getPieces(0));

        Piece whitePiece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.PAWN);
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

        Piece pawnPiece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.PAWN);
        assertEquals("white", pawnPiece.getColor());
        assertEquals('P', pawnPiece.getRepresentation());

        Piece knightPiece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.KNIGHT);
        assertEquals("white", knightPiece.getColor());
        assertEquals('N', knightPiece.getRepresentation());

        Piece rookPiece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.ROOK);
        assertEquals("white", rookPiece.getColor());
        assertEquals('R', rookPiece.getRepresentation());

        Piece bishopPiece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.BISHOP);
        assertEquals("white", bishopPiece.getColor());
        assertEquals('B', bishopPiece.getRepresentation());

        Piece queenPiece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.QUEEN);
        assertEquals("white", queenPiece.getColor());
        assertEquals('Q', queenPiece.getRepresentation());

        Piece kingPiece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.KING);
        assertEquals("white", kingPiece.getColor());
        assertEquals('K', kingPiece.getRepresentation());
    }

    @Test
    public void 검은색_체스말_생성(){
        Piece pawnPiece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.PAWN);
        assertEquals("black", pawnPiece.getColor());
        assertEquals('p', pawnPiece.getRepresentation());

        Piece knightPiece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.KNIGHT);
        assertEquals("black", knightPiece.getColor());
        assertEquals('n', knightPiece.getRepresentation());

        Piece rookPiece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.ROOK);
        assertEquals("black", rookPiece.getColor());
        assertEquals('r', rookPiece.getRepresentation());

        Piece bishopPiece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.BISHOP);
        assertEquals("black", bishopPiece.getColor());
        assertEquals('b', bishopPiece.getRepresentation());

        Piece queenPiece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.QUEEN);
        assertEquals("black", queenPiece.getColor());
        assertEquals('q', queenPiece.getRepresentation());

        Piece kingPiece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.KING);
        assertEquals("black", kingPiece.getColor());
        assertEquals('k', kingPiece.getRepresentation());
    }

    @Test
    public void testCreate() {
        board.initialize();

        assertEquals(32,board.pieceCount());

        String blankRank = StringUtil.appendNewLine("........");

        assertEquals(StringUtil.appendNewLine("rnbqkbnr") +
                        StringUtil.appendNewLine("pppppppp") +
                        blankRank + blankRank + blankRank + blankRank +
                        StringUtil.appendNewLine("PPPPPPPP") +
                        StringUtil.appendNewLine("RNBQKBNR"),
                board.print());
    }


    @Test
    public void 말_종류_개수_반환(){
        board.initialize();
        board.getNumberOfPieces("white", 'p');
        board.getNumberOfPieces("white", 'n');

    }
}