package com.tdd.tddjava.ch05itctaccode;

import com.tdd.tddjava.ch05tictaccode.Connect4TDD;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Connect4TDDSpec {
    private Connect4TDD tested;

    @BeforeMethod
    public void beforeEachTest(){
        tested=new Connect4TDD();
    }

    @Test
    public void whenThenGameStartedTheBoardIsEmpty(){
        assertEquals(tested.getNumberOfDiscs(),0);
    }
}
