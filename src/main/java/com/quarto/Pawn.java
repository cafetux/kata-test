package com.quarto;

public class Pawn {
    private final boolean isSmall;
    private final boolean isSquare;

    public Pawn(boolean isSmall) {
        this.isSmall = isSmall;
        this.isSquare = false;
    }

    public Pawn(boolean isSmall, boolean isSquare) {
        this.isSmall = isSmall;
        this.isSquare = isSquare;
    }

    public boolean isSmall() {
        return isSmall;
    }
}
