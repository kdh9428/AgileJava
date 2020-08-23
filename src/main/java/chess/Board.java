package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public final static int BOARD_ROW = 8;
    public final static int BOARD_COL = 8;
    private List<Piece> pieces = new ArrayList<>(BOARD_ROW * BOARD_COL);

    public Board() {
        for (int i = 0; i < BOARD_ROW; i++) {
            for (int j = 0; j < BOARD_COL; j++) {
                pieces.add(null);
            }
        }
    }

    public List<Piece> getAllPawns() {
        return pieces;
    }

    public void add(Piece piece) {
        this.pieces.add(piece);
    }

    public Piece getPawn(int number) {
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

        for (int i = 0; i < BOARD_ROW; i++) {
            for (int j = 0; j < BOARD_COL; j++) {
                pieces.set(i * BOARD_ROW + j, null);
            }
        }

        for (int i = 0; i < BOARD_ROW; i++)
            pieces.set(i + BOARD_ROW, Piece.createPiece(Piece.BLACK));

        for (int i = 0; i < BOARD_ROW; i++)
            pieces.set(i + (BOARD_ROW * 6), Piece.createPiece(Piece.WHITE));

    }
}
