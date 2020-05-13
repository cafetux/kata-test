package com.quarto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    private Line given_a_line(Pawn pawn1, Pawn pawn2, Pawn pawn3) {
        return new Line(asList(pawn1, pawn2, pawn3));
    }

    private Line given_a_line(Pawn pawn1, Pawn pawn2, Pawn pawn3, Pawn pawn4) {
        return new Line(asList(pawn1, pawn2, pawn3, pawn4));
    }

    private Pawn tallPawn() {
        return new Pawn(false);
    }

    private Pawn smallPawn() {
        return new Pawn(true);
    }


    public boolean checkIfGameIsWon(Line line) {
        return line.allPawnAreSame();
    }

}
