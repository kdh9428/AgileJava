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
        assertEquals('p', pawnPiece.getRepresentation());

        Piece knightPiece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.KNIGHT);
        assertEquals("white", knightPiece.getColor());
        assertEquals('n', knightPiece.getRepresentation());

        Piece rookPiece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.ROOK);
        assertEquals("white", rookPiece.getColor());
        assertEquals('r', rookPiece.getRepresentation());

        Piece bishopPiece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.BISHOP);
        assertEquals("white", bishopPiece.getColor());
        assertEquals('b', bishopPiece.getRepresentation());

        Piece queenPiece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.QUEEN);
        assertEquals("white", queenPiece.getColor());
        assertEquals('q', queenPiece.getRepresentation());

        Piece kingPiece = Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.KING);
        assertEquals("white", kingPiece.getColor());
        assertEquals('k', kingPiece.getRepresentation());
    }

    @Test
    public void 검은색_체스말_생성() {
        Piece pawnPiece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.PAWN);
        assertEquals("black", pawnPiece.getColor());
        assertEquals('P', pawnPiece.getRepresentation());

        Piece knightPiece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.KNIGHT);
        assertEquals("black", knightPiece.getColor());
        assertEquals('N', knightPiece.getRepresentation());

        Piece rookPiece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.ROOK);
        assertEquals("black", rookPiece.getColor());
        assertEquals('R', rookPiece.getRepresentation());

        Piece bishopPiece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.BISHOP);
        assertEquals("black", bishopPiece.getColor());
        assertEquals('B', bishopPiece.getRepresentation());

        Piece queenPiece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.QUEEN);
        assertEquals("black", queenPiece.getColor());
        assertEquals('Q', queenPiece.getRepresentation());

        Piece kingPiece = Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.KING);
        assertEquals("black", kingPiece.getColor());
        assertEquals('K', kingPiece.getRepresentation());
    }

    @Test
    public void testCreate() {
        board.initialize();

        assertEquals(64, board.pieceCount());

        String blankRank = StringUtil.appendNewLine("........");

        assertEquals(StringUtil.appendNewLine("rnbqkbnr") +
                        StringUtil.appendNewLine("pppppppp") +
                        blankRank + blankRank + blankRank + blankRank +
                        StringUtil.appendNewLine("PPPPPPPP") +
                        StringUtil.appendNewLine("RNBQKBNR"),
                board.print());
    }

    @Test
    public void emptyBoard() {

        Board board = new Board();
        board.createEmptyBoard();
    }


    @Test
    public void 말_종류_개수_반환() {
        board.initialize();
        int count = board.getNumberOfPieces("white", 'p');
        board.getNumberOfPieces("white", 'n');

        System.out.println(count);

    }

    @Test
    public void 말_위치_반환() {

        board.initialize();
        Piece pie = board.getPositionOfChessPiece('a', 1);
        Piece pie1 = board.getPositionOfChessPiece('b', 4);
        System.out.println(pie.getColor() + ", " + pie.getRepresentation());
        System.out.println(pie1.getColor() + ", " + pie1.getRepresentation());
    }

    @Test
    public void 임의의_위치에_말을_추가() {
        board.createEmptyBoard();
        board.addPieceToCollection(Piece.createBlack(Piece.TypesOfChessPiece.KING), 'b', 3);
        board.addPieceToCollection(Piece.createBlack(Piece.TypesOfChessPiece.ROOK), 'b', 4);
        board.addPieceToCollection(Piece.createWhite(Piece.TypesOfChessPiece.KING), 'c', 5);

        Piece piece = board.getPositionOfChessPiece('b', 3);
        assertEquals(piece.getColor(), Piece.Color.BLACK.stringColor);
        assertEquals(piece.getType(), Piece.TypesOfChessPiece.KING);

        piece = board.getPositionOfChessPiece('b', 4);
        assertEquals(piece.getColor(), Piece.Color.BLACK.stringColor);
        assertEquals(piece.getType(), Piece.TypesOfChessPiece.ROOK);

        piece = board.getPositionOfChessPiece('c', 5);
        assertEquals(piece.getColor(), Piece.Color.WHITE.stringColor);
        assertEquals(piece.getType(), Piece.TypesOfChessPiece.KING);

        String blankRank = StringUtil.appendNewLine("........");

        assertEquals(blankRank +
                blankRank +
                StringUtil.appendNewLine(".K......") +
                StringUtil.appendNewLine(".R......") +
                StringUtil.appendNewLine("..k.....") +
                blankRank +
                blankRank +
                blankRank, board.print());
    }

    @Test
    public void 체스말_총점() {

        board.createEmptyBoard();
        board.addPieceToCollection(Piece.createBlack(Piece.TypesOfChessPiece.KING), 'b', 1);
        board.addPieceToCollection(Piece.createBlack(Piece.TypesOfChessPiece.ROOK), 'c', 1);
        board.addPieceToCollection(Piece.createBlack(Piece.TypesOfChessPiece.PAWN), 'a', 2);
        board.addPieceToCollection(Piece.createBlack(Piece.TypesOfChessPiece.PAWN), 'c', 2);
        board.addPieceToCollection(Piece.createBlack(Piece.TypesOfChessPiece.BISHOP), 'd', 2);
        board.addPieceToCollection(Piece.createBlack(Piece.TypesOfChessPiece.PAWN), 'b', 3);
        board.addPieceToCollection(Piece.createBlack(Piece.TypesOfChessPiece.QUEEN), 'e', 3);

        board.addPieceToCollection(Piece.createWhite(Piece.TypesOfChessPiece.KNIGHT), 'f', 5);
        board.addPieceToCollection(Piece.createWhite(Piece.TypesOfChessPiece.QUEEN), 'g', 5);
        board.addPieceToCollection(Piece.createWhite(Piece.TypesOfChessPiece.PAWN), 'f', 6);
        board.addPieceToCollection(Piece.createWhite(Piece.TypesOfChessPiece.PAWN), 'h', 6);
        board.addPieceToCollection(Piece.createWhite(Piece.TypesOfChessPiece.PAWN), 'f', 7);
        board.addPieceToCollection(Piece.createWhite(Piece.TypesOfChessPiece.PAWN), 'g', 7);
        board.addPieceToCollection(Piece.createWhite(Piece.TypesOfChessPiece.ROOK), 'e', 8);
        board.addPieceToCollection(Piece.createWhite(Piece.TypesOfChessPiece.KING), 'f', 8);

        double totalBlackPiece = board.allScoreOfPiece(Piece.Color.BLACK);
        double totalWhitePiece = board.allScoreOfPiece(Piece.Color.WHITE);


        System.out.println(board.print());

        System.out.println("검정색 합계 : " + totalBlackPiece + "흰색 말 합계 :" + totalWhitePiece);

    }
}