package chess;

import pieces.Piece;

import java.util.List;

public class DrawBoard {

    public static final String NEWLINE = System.lineSeparator();

    public String getBoard(Board board) {

        List<Piece> pieces = board.getAllPawns();

        StringBuilder draw = new StringBuilder();


        for (int i = 0; i < Board.BOARD_ROW; i++) {
            for (int j = 0; j < Board.BOARD_COL; j++) {
                if (pieces.get(i * Board.BOARD_ROW + j) == null) {
                    draw.append("-");
                } else {
                    draw.append(pieces.get(i * Board.BOARD_ROW + j).getRepresentation());
                }
            }
            draw.append(NEWLINE);
        }
//
//        for (Pawn pawn : pawns) {
//            if (pawn == null) {
//                draw.append("-");
//            } else {
//                draw.append(pawn.getInitials());
//            }
//        }

        System.out.println(draw.toString());
        return draw.toString();
    }

}
