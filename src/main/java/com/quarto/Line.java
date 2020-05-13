package com.quarto;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Pawn> pawns;

    public Line() {
        pawns = new ArrayList<Pawn>();
    }

    public Line(List<Pawn> pawns) {
        this.pawns = pawns;
    }

    public boolean allPawnAreSame() {
        return pawns.isEmpty() ? false : pawns.get( 2 ).isSmall();
    }
}
