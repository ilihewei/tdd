package com.tdd.tddjava.ch03tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeSpec {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private TicTacToe ticTacToe;

    @Before
    public final void before() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(5, 2);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 5);
    }

    @Test
    public void whenOccupiedThenRuntimeException() {
        ticTacToe.play(2, 1);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 1);
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenNext() {
        Assert.assertEquals('X', ticTacToe.nextPlayer());
    }


    @Test
    public void givenTurnWasWhenNextPlayerThenO() {
        ticTacToe.play(1, 1);
        Assert.assertEquals('O', ticTacToe.nextPlayer());
    }

    @Test
    public void whenPlayThenNoWinner() {
        String actual = ticTacToe.play(1, 1);
        Assert.assertEquals("No winner", actual);
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner() {
        ticTacToe.play(1, 1);//x
        ticTacToe.play(1, 2);//o
        ticTacToe.play(2, 1);//x
        ticTacToe.play(2, 2);//o

        String actual = ticTacToe.play(3, 1);
        Assert.assertEquals("X is the winner", actual);
    }


    //玩家基于一条直线就赢了
    @Test
    public void whenPlayAndWholeVerticalLineThenWinner() {
        ticTacToe.play(2, 1);//x
        ticTacToe.play(1, 1);//o
        ticTacToe.play(3, 1);//x
        ticTacToe.play(1, 2);//o
        ticTacToe.play(2,2);//x
        String actual = ticTacToe.play(1, 3);//0
        Assert.assertEquals("O is the winner", actual);
    }

    //8 对角线
    @Test
    public  void whenPlayAndTopPottomDiagonalLincThcnWinner(){
        ticTacToe.play(1,1);//x
        ticTacToe.play(1,2);//o
        ticTacToe.play(2,2);//x
        ticTacToe.play(1,3);//o
        String actual=ticTacToe.play(3,3);//x
        Assert.assertEquals("X is the winner",actual);
    }

    @Test
    public void whenPlayAndBottomTopdiagonal(){
        ticTacToe.play(1,3);//x
        ticTacToe.play(1,1);//o
        ticTacToe.play(2,2);//x
        ticTacToe.play(1,2);//o
        String actual = ticTacToe.play(3, 1);//x
        Assert.assertEquals("X is the winner",actual);
    }

    //处理平局
    public  void whenAllBoxesAreFilledThenDraw(){
        ticTacToe.play(1,1);
        ticTacToe.play(1,2);
        ticTacToe.play(1,3);
        ticTacToe.play(2,1);
        ticTacToe.play(2,3);
        ticTacToe.play(2,2);
        ticTacToe.play(3,1);
        ticTacToe.play(3,3);
        String actual = ticTacToe.play(3, 2);
        Assert.assertEquals("The result is draw",actual);
    }
}
