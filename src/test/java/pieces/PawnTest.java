package pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    public void TestCreate(){

        final String WHITE = "white";
        final String BLACK = "black";

        Pawn pawn = new Pawn();
        assertEquals(WHITE, pawn.getColor());

        Pawn pawn1 = new Pawn(BLACK);
        assertEquals(BLACK, pawn1.getColor());
    }

    @Test
    public void 전역_상수(){

        Pawn pawn = new Pawn();
        String defaultColor = Pawn.WHITE;
        assertEquals(defaultColor, pawn.getColor());
    }

}
