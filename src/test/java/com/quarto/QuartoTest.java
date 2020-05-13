package com.quarto;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class QuartoTest {



    @Test
    public void should_not_win_when_empty() {
        assertThat(checkIfGameIsWon(new Line())).isFalse();
    }

    @Test
    public void should_win_when_four_pawns_are_small() {
        ArrayList<Pawn> pawns = new ArrayList<Pawn>();
        boolean isSmall = true;
        pawns.add( new Pawn(isSmall) );
        pawns.add( new Pawn(isSmall) );
        pawns.add( new Pawn(isSmall) );
        pawns.add( new Pawn(isSmall) );
        assertThat( checkIfGameIsWon( new Line(pawns) ) ).isTrue();
    }


    public boolean checkIfGameIsWon(Line line) {

        return false;
    }

}
