package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Board {

    public final static int BOARD_ROW = 8;
    public final static int BOARD_COL = 8;
    private List<Piece> pieces = new ArrayList<>();

    public Board() {
//        for (int i = 0; i < BOARD_ROW; i++) {
//            for (int j = 0; j < BOARD_COL; j++) {
//                pieces.add(null);
//            }
//        }
    }

    public List<Piece> getAllPawns() {
        return pieces;
    }

    public void addPieces(Piece piece) {
        pieces.add(piece);
    }

    public Piece getPieces(int number) {
        return pieces.get(number);
    }

    public int getNumberOfPawns() {
        int count = 0;
        for (Piece piece : pieces) {
            if (piece != null) {
                count++;
            }
        }
        return count;
    }

    public void initialize() {

//        for (int i = 0; i < BOARD_ROW; i++) {
//            for (int j = 0; j < BOARD_COL; j++) {
//                pieces.set(i * BOARD_ROW + j, null);
//            }
//        }

        initPieceLine(0, Piece.WHITE);

        for (int i = 0; i < BOARD_ROW; i++)
            pieces.add(i + BOARD_ROW, Piece.createPiece(Piece.WHITE, Piece.PAWN));


        for (int i = 0; i < BOARD_ROW; i++)
            pieces.add(i + (BOARD_ROW * 2), Piece.createPiece(Piece.BLACK, Piece.PAWN));

        initPieceLine(0, Piece.BLACK);

    }

    private void initPieceLine(int line, String color) {

        pieces.add(Piece.createPiece(color, Piece.ROOK));
        pieces.add(Piece.createPiece(color, Piece.KNIGHT));
        pieces.add(Piece.createPiece(color, Piece.BISHOP));
        pieces.add(Piece.createPiece(color, Piece.QUEEN));
        pieces.add(Piece.createPiece(color, Piece.KING));
        pieces.add(Piece.createPiece(color, Piece.BISHOP));
        pieces.add(Piece.createPiece(color, Piece.KNIGHT));
        pieces.add(Piece.createPiece(color, Piece.ROOK));

    }

    public int pieceCount() {
        return Piece.getBlackPieceCount() + Piece.getWhitePieceCount();
    }

    public String print() {

        StringBuilder builder = new StringBuilder();

        pieces.stream().forEach(a -> builder.append(a.getInitials()));

        return builder.toString();
    }
}
