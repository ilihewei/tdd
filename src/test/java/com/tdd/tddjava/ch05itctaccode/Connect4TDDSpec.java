package com.tdd.tddjava.ch05itctaccode;

import com.tdd.tddjava.ch05tictaccode.Connect4TDD;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class Connect4TDDSpec {
    private Connect4TDD tested;

    @Rule
    public ExpectedException expection = ExpectedException.none();


    @Before
    public void beforeEachTest(){
        tested=new Connect4TDD();
    }

    @Test
    public void whenThenGameStartedTheBoardIsEmpty(){
        assertThat(tested.getNumberOfDiscs(),is(0));
    }

    @Test
    public void whenDiscOutsideBoardThenRuntimeException(){
        int column=-1;
        expection.expect(RuntimeException.class);
        expection.expectMessage("Invalid column"+column);
        tested.putDiscInColumn(column);
    }

    @Test
    public  void whenFirstInsertedColumnPositionIsZero(){
        int column=1;
        assertThat(tested.putDiscInColumn(column),is(0));
    }

    @Test
    public  void  whenSecondDiscInsertedInColumnThenPositionIsOne(){
        int column=1;
        tested.putDiscInColumn(column);
        assertThat(tested.putDiscInColumn(column),is(0));
    }

    @Test
    public void whenSecondDiscInseredInColumnPositionIsOne(){
        int column=1;
        tested.putDiscInColumn(column);
        assertThat(tested.putDiscInColumn(column),is(1));
    }

    @Test
    public void whenDiscInsertedThenNumberOfDiscsIncreases(){
        int column=1;
        tested.putDiscInColumn(column);
        assertThat(tested.getNumberOfDiscs(),is(1));
    }

    @Test
    public void whenNoMoreRoomColumnThenRunTimeException(){
        int column=1;
        int maxDiscsInColumn=6;//the number of rows
        for (int times = 0; times<maxDiscsInColumn ; times++) {
            tested.putDiscInColumn(column);
        }

        expection.expect(RuntimeException.class);
        expection.expectMessage("No more room in column"+column);
        tested.putDiscInColumn(column);
    }


    @Test
    public void whenFistPlaysThenDiscColorIsRed(){
        assertThat(tested.getCurrentPlayer(),is("R"));
    }

    @Test
    public void whenSecondPlaysThenDiscColorIsRed(){
        int column=1;
        tested.putDiscInColumn(column);
        assertThat(tested.getCurrentPlayer(),is("R"));
    }

}
