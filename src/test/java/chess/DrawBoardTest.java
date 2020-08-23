package chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrawBoardTest {

    @Test
    public void 체스판_그리기(){

        Board board = new Board();

        board.initialize();

        DrawBoard drawBoard = new DrawBoard();
        drawBoard.getBoard(board);
    }

}