package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Board {

    public final static int BOARD_ROW = 8;
    public final static int BOARD_COL = 8;
    private List<Piece> pieces = new ArrayList<>();
    Map<Piece.TypesOfChessPiece, Double> pieceTypesCount;

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
            pieces.add(Piece.createPiece(Piece.Color.WHITE, Piece.TypesOfChessPiece.PAWN));

        for (int i = 0; i < BOARD_ROW * 4; i++)
            pieces.add(Piece.createPiece(Piece.Color.NONE, Piece.TypesOfChessPiece.NO_PIECE));

        for (int i = 0; i < BOARD_ROW; i++)
            pieces.add(Piece.createPiece(Piece.Color.BLACK, Piece.TypesOfChessPiece.PAWN));

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

        for (Piece piece : pieces) {
            if (pieces.indexOf(piece) % 8 == 0 && pieces.indexOf(piece) != 0) {
                builder.append(DrawBoard.NEWLINE);

                System.out.println(pieces.indexOf(piece));
            }

            builder.append(piece.getRepresentation());
        }
        builder.append(DrawBoard.NEWLINE);
        return builder.toString();
    }


    public int getNumberOfPieces(String color, char representation) {

        int countPiece = 0;
        countPiece = (int) pieces.stream().filter(a -> a.getRepresentation() == representation).filter(a -> a.getColor().equals(color)).count();

        //        pieceTypesCount = new EnumMap<Piece.TypesOfChessPiece, Double>(Piece.TypesOfChessPiece.class);

        return countPiece;
    }

    public Piece getPositionOfChessPiece(char row, int column) {

        int rowNumber = Character.getNumericValue(row) - 10;

        int ch = rowNumber + (column - 1) * 8;
        System.out.println("row : " + row + ", column : " + column + ", get number : " + ch);
        Piece piece = pieces.get(rowNumber + (column - 1) * 8);

        return piece;
    }

    public void createEmptyBoard() {
        pieces.clear();

        for (int i = 0; i < BOARD_ROW * BOARD_COL; i++) {
            pieces.add(Piece.noPiece());
        }
    }

    public void addPieceToCollection(Piece piece, char row, int column) {
        int rowNumber = Character.getNumericValue(row) - 10;
        pieces.set(rowNumber + (column - 1) * 8, piece);
    }

    public double allScoreOfPiece(Piece.Color color) {

        double pieceValue = 0;

        pieceTypesCount = new EnumMap<Piece.TypesOfChessPiece, Double>(Piece.TypesOfChessPiece.class);

        for (Piece piece : pieces) {

            int pieceIndex = pieces.indexOf(piece);

//            if (piece.getType() == Piece.TypesOfChessPiece.PAWN) {
//                pawnIndexCheck(pieceIndex, color);
//            }
            switch (piece.getType()){
                case PAWN:
//                    piece.setPieceValue(1);
                    pawnIndexCheck(pieceIndex, color);
                    break;
                case KNIGHT:
                    piece.setPieceValue(2.5);
                    break;
                case ROOK:
                    piece.setPieceValue(5);
                    break;
                case QUEEN:
                    piece.setPieceValue(9);
                    break;
                case BISHOP:
                    piece.setPieceValue(3);
                    break;
                case KING:
                case NO_PIECE:
                    piece.setPieceValue(0);
            }

            if (piece.getColor() == color.stringColor) {
                System.out.print(piece.getPieceValue() + ", ");
                pieceValue += piece.getPieceValue();
            }
        }
        return pieceValue;
    }

    private void pawnIndexCheck(int pieceIndex, Piece.Color color) {


        if (pieceIndex <= 55) {
            Piece pawnPiece = pieces.get(pieceIndex);
            Piece addEightToPiece = pieces.get(pieceIndex + 8);

            if (pawnPiece.getType() == addEightToPiece.getType() && color.stringColor == pawnPiece.getColor()) {

                pawnPiece.setPieceValue(0.5);
                addEightToPiece.setPieceValue(0.5);
            }
        }
    }
}
