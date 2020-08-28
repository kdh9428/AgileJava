package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

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

        initPieceLine(0, Piece.Color.WHITE);

        for (int i = 0; i < BOARD_ROW; i++)
            pieces.add(i + BOARD_ROW, Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.PAWN));

        for (int i = 0; i < BOARD_ROW; i++)
            pieces.add(i + (BOARD_ROW * 2), Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.PAWN));

        initPieceLine(0, Piece.Color.BLACK);

    }

    private void initPieceLine(int line, Piece.Color color) {

        pieces.add(Piece.createPiece(color, Piece.TypesOfChessPiece.ROOK));
        pieces.add(Piece.createPiece(color, Piece.TypesOfChessPiece.KNIGHT));
        pieces.add(Piece.createPiece(color, Piece.TypesOfChessPiece.BISHOP));
        pieces.add(Piece.createPiece(color, Piece.TypesOfChessPiece.QUEEN));
        pieces.add(Piece.createPiece(color, Piece.TypesOfChessPiece.KING));
        pieces.add(Piece.createPiece(color, Piece.TypesOfChessPiece.BISHOP));
        pieces.add(Piece.createPiece(color, Piece.TypesOfChessPiece.KNIGHT));
        pieces.add(Piece.createPiece(color, Piece.TypesOfChessPiece.ROOK));

    }

    public int pieceCount() {
        return Piece.getBlackPieceCount() + Piece.getWhitePieceCount();
    }

    public String print() {

        StringBuilder builder = new StringBuilder();

//        for(int i = 0; i < BOARD_ROW ; i++){
//            for (int j = i * BOARD_ROW ; j < 15; j++){
//                builder.append(pieces.get(j).getInitials());
//            }
//                builder.append(DrawBoard.NEWLINE);
//        }
//
//        for (int i = 0; i < 4; i++)
//        builder.append("........");
//
//        for(int i = 15; i < 31 ; i++){
//            for (int j = i * BOARD_ROW ; j < 15; j++){
//                builder.append(pieces.get(j).getInitials());
//            }
//            builder.append(DrawBoard.NEWLINE);
//        }

        for (Piece piece : pieces) {
            if (pieces.indexOf(piece) % 8 == 0 && pieces.indexOf(piece) != 0) {
                builder.append(DrawBoard.NEWLINE);

                System.out.println(pieces.indexOf(piece));
            }

            if (pieces.indexOf(piece) == 16) {
                builder.append("........");
                builder.append(DrawBoard.NEWLINE);
                builder.append("........");
                builder.append(DrawBoard.NEWLINE);
                builder.append("........");
                builder.append(DrawBoard.NEWLINE);
                builder.append("........");
                builder.append(DrawBoard.NEWLINE);
            }
            builder.append(piece.getRepresentation());
        }
        builder.append(DrawBoard.NEWLINE);
        return builder.toString();
    }


    public int getNumberOfPieces(String color, char representation) {

        int countPiece = 0;

        for (Piece piece : pieces) {
            if (piece.getRepresentation() == representation)
                countPiece++;
        }

        int count = (int) pieces.stream().filter(a -> a.getRepresentation() == representation).filter(a -> a.getColor().equals(color)).count();

        System.out.println(count);

        return countPiece;
    }
}
