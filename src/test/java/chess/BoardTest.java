package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp(){
        board = new Board();
    }

    @Test
    public void 체스판_초기화(){
        Board board = new Board();
    }

    @Test
    public void 장기말_추가(){
        Pawn pawn = new Pawn(Pawn.BLACK);
        board.add(pawn);

        assertEquals(1,board.getNumberOfPawns());
        assertEquals(pawn, board.getPawn(0));

        Pawn whitePawn = new Pawn(Pawn.WHITE);
        board.add(whitePawn);
        assertEquals(2, board.getNumberOfPawns());
        assertEquals(whitePawn,board.getPawn(1));
    }

    @Test
    public void Pawn_이외의_객체_불가(){

//        board.add(new Integer("7"));
    }


}