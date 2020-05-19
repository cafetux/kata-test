package com.quarto;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class QuartoTest {

    @Test
    public void should_not_win_when_empty() {
        assertThat(checkIfGameIsWon(new Line())).isFalse();
    }

    @Test
    public void should_win_when_four_pawns_are_small() {
        Line line = given_a_line(smallPawn(), smallPawn(), smallPawn(), smallPawn());
        assertThat( checkIfGameIsWon( line ) ).isTrue();
    }

    @Test
    public void should_not_win_when_only_one_pawn_is_tall() {
        Line line = given_a_line(smallPawn(), smallPawn(), tallPawn(), smallPawn());
        assertThat( checkIfGameIsWon(line) ).isFalse();
    }

    @Test
    public void should_win_when_four_pawns_are_tall () {
        Line line = given_a_line(tallPawn(), tallPawn(), tallPawn(), tallPawn());
        assertThat( checkIfGameIsWon(line) ).isTrue();
    }

    @Test
    public void should_not_win_when_all_pawns_are_tall_but_line_not_complete() {
        Line line = given_a_line(tallPawn(), tallPawn(), tallPawn());
        assertThat( checkIfGameIsWon(line) ).isFalse();
    }

    @Test
    public void should_win_when_four_pawns_are_square() {
        Line line = given_a_line(squarePawn(), squarePawn(), squarePawn(), squarePawn());
        assertThat( checkIfGameIsWon( line ) ).isTrue();
    }

    @Test
    public void should_win_when_four_pawns_are_round() {
        Line line = given_a_line( roundPawn(), roundPawn(), roundPawn(), roundPawn() );
        assertThat( checkIfGameIsWon( line ) ).isTrue();
    }

    private Line given_a_line(Pawn pawn1, Pawn pawn2, Pawn pawn3) {
        return new Line(asList(pawn1, pawn2, pawn3));
    }

    private Line given_a_line(Pawn pawn1, Pawn pawn2, Pawn pawn3, Pawn pawn4) {
        return new Line(asList(pawn1, pawn2, pawn3, pawn4));
    }

    private Pawn roundPawn() { return new Pawn( Property.ROUND ); }

    private Pawn squarePawn() { return new Pawn( Property.SQUARE ); }

    private Pawn tallPawn() {
        return new Pawn(Property.TALL);
    }

    private Pawn smallPawn() {
        return new Pawn(Property.SMALL);
    }


    public boolean checkIfGameIsWon(Line line) {
        return line.allPawnAreSame();
    }

}
