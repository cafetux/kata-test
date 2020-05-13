package com.quarto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuartoTest {



    @Test
    public void should_not_win_when_empty() {
           assertThat(checkIfGameIsWon(new Line())).isFalse();
    }


    public boolean checkIfGameIsWon(Line line) {
        return true;
    }

}
