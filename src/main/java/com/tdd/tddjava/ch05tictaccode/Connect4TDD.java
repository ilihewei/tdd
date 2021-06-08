package com.tdd.tddjava.ch05tictaccode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author apple
 */
public class Connect4TDD {
    private  static  final  int ROWS=6;

    private  static  final int COLUMNS=7;

    private  static  final String EMPTY=" ";

    private static  final String RED="R";

    private  static  final  String GREEN="G";

    private  String currentPlayer=RED;


    private String[][] board=new String[ROWS][COLUMNS];

    public  Connect4TDD(){
        for (String[] row:board){
            Arrays.fill(row,EMPTY);
        }
    }

    public int getNumberOfDiscs(){
        return IntStream.range(0,COLUMNS).map(this::putDiscInColumn).sum();
    }

    private   int getNumberOfDiscsInColumn(int column){
        return (int)IntStream.range(0,ROWS).filter(row->!EMPTY.equals(board[row][column])).count();
    }

    public  int putDiscInColumn(int column){

        checkColumn(column);
        int row=getNumberOfDiscsInColumn(column);
        checkPositionToInsert(row,column);
        board[row][column]="X";
        switchPlayer();
        return row;

    }

    private  void checkColumn(int column){
        if(column<0||column>=COLUMNS){
            throw  new RuntimeException("Invalid column"
            +column);
        }
    }

    private  void checkPositionToInsert(int row,int column){
        if(row==ROWS){
            throw  new RuntimeException("No more room in column"+column);
        }
    }


    public String getCurrentPlayer() {
        return currentPlayer;
    }

    private void switchPlayer(){
        if(RED.equals(currentPlayer)){
            currentPlayer=GREEN;
        }else {
            currentPlayer=RED;
        }
    }

//    public  int putDiscInColumn(int column){
//        switchPlayer();
//        return row;
//    }
}
