package com.quarto;

public class Pawn {
    private Property property;

    public Pawn(Property property) {
        this.property = property;
    }

    public boolean isSmall() {
        return property == Property.SMALL;
    }

    public boolean isSquare() {
        return property == Property.SQUARE;
    }

    public boolean isTall() {
        return property == Property.TALL;
    }

    public boolean isRound() {
        return property == Property.ROUND;
    }
}
