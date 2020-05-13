package com.quarto;

import java.util.List;

public class Line {

    private final int size;

    public Line() {
        this.size=0;
    }

    public Line(List<Pawn> pawns) {
        this.size = pawns.size();
    }

    public int size() {
        return size;
    }
}
