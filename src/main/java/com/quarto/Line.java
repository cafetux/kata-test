package com.quarto;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Pawn> pawns;

    public Line() {
        pawns = new ArrayList<>();
    }

    public Line(List<Pawn> pawns) {
        this.pawns = pawns;
    }

    public boolean allPawnAreSame() {
        return pawns.size() == 4 &&
                (pawns.stream().allMatch(Pawn::isSmall) || pawns.stream().noneMatch(Pawn::isSmall));
    }
}
