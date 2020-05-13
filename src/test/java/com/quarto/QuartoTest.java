package com.quarto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QuartoTest {



    @Test
    public void should_not_win_when_empty() {
        assertThat(checkIfGameIsWon(new Line())).isFalse();
    }

    @Test
    public void should_win_when_four_pawns_are_small() {
        List<Pawn> pawns = new ArrayList<Pawn>();
        pawns.add(smallPawn());
        pawns.add(smallPawn());
        pawns.add(smallPawn());
        pawns.add(smallPawn());
        assertThat( checkIfGameIsWon( new Line(pawns) ) ).isTrue();
    }

    @Test
    public void should_not_win_when_only_one_pawn_is_tall() {
        List<Pawn> pawns = new ArrayList<Pawn>();
        pawns.add(smallPawn());
        pawns.add(smallPawn());
        pawns.add(tallPawn());
        pawns.add(smallPawn());
        assertThat( checkIfGameIsWon( new Line(pawns) ) ).isFalse();
    }

    @Test
    public void should_win_when_four_pawns_are_tall () {
        List<Pawn> pawns = new ArrayList<Pawn>();
        pawns.add(tallPawn());
        pawns.add(tallPawn());
        pawns.add(tallPawn());
        pawns.add(tallPawn());
        assertThat( checkIfGameIsWon( new Line(pawns) ) ).isTrue();

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
