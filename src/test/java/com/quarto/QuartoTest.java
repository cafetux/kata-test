package com.quarto;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class QuartoTest {

    @Test
    public void should_not_win_when_empty_line() {
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

    @Test
    public void should_not_win_when_all_pawns_are_holey_but_column_not_complete() {
        Line line1 = given_a_line( holeyPawn() );
        Line line2 = given_a_line( holeyPawn() );

        assertThat( checkIfGameIsWon(new Column(asList(line1.get(0), line2.get(0)))) ).isFalse();
    }

    @Test
    public void should_win_when_four_pawns_are_holey() {
        Line line1 = given_a_line( holeyPawn() );
        Line line2 = given_a_line( holeyPawn() );
        Line line3 = given_a_line( holeyPawn() );
        Line line4 = given_a_line( holeyPawn() );
        assertThat( checkIfGameIsWon(new Column(asList(line1.get(0), line2.get(0), line3.get(0), line4.get(0)))) ).isTrue();
    }


    private Line given_a_line(Pawn pawn1) { return new Line(asList(pawn1)); }

    private Line given_a_line(Pawn pawn1, Pawn pawn2, Pawn pawn3) {
        return new Line(asList(pawn1, pawn2, pawn3));
    }

    private Line given_a_line(Pawn pawn1, Pawn pawn2, Pawn pawn3, Pawn pawn4) {
        return new Line(asList(pawn1, pawn2, pawn3, pawn4));
    }

    private Pawn holeyPawn() { return new Pawn( (Property.HOLEY) ); }

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

    private boolean checkIfGameIsWon(Column column) { return column.allPawnsAreSame(); }

}
