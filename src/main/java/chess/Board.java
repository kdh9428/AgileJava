package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> pawns = new ArrayList<>();

    public void add(Pawn pawn) {
        this.pawns.add(pawn);
    }

    public Pawn getPawn(int number) {
        return pawns.get(number);
    }

    public int getNumberOfPawns() {
        return pawns.size();
    }
}
