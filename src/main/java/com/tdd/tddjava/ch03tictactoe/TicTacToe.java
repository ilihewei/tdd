package com.tdd.tddjava.ch03tictactoe;

public class TicTacToe {

    private final   Character[][] board={{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};

    private  final int maxPosition =3;
    private final int minPosition =1;
    private char lastPlayer='\0';
    private final int SIZE=3;
    public String play(int x, int y) {
//        if (x<1 ||x>3){
//             throw  new RuntimeException("x is outside board");
//        }
//
//        if (y<1 ||y>3){
//            throw  new RuntimeException("y is outside board");
//        }
//
//        if (board[x-1][y-1]!='\0'){
//            throw
//                    new RuntimeException("Box is occupied");
//        }else {
//            board[x-1][y-1]='X';
//        }
        checkAxis(x);
        checkAxis(y);
        lastPlayer=nextPlayer();
        setBox(x, y,lastPlayer);

//        for (int index=0;index<3;index++){
//            if (board[0][index]==lastPlayer&&
//            board[1][index]==lastPlayer&&
//            board[2][index]==lastPlayer){
//                return lastPlayer+" is the winner";
//            }
//        }
        if (isWin()){
            return lastPlayer+" is the winner";

        }else  if (isDraw()){
            return  "The result is draw";
        }else {

            return "No winner";
        }
    }

    private  boolean isWin(){
        int playerTotal=lastPlayer*3;
        char diagonal1='\0';
        char diagonal2='\0';
        for (int i=0;i<SIZE;i++){
            diagonal1+=board[i][i];
            diagonal2+=board[i][SIZE-i-1];
          if ((board[0][i]+board[1][i]+board[2][i])==playerTotal){
              return true;
          }else  if ((board[i][0]+board[i][1]+board[i][2])==playerTotal){
              return true;
          }
        }
        if (diagonal1==playerTotal||diagonal2==playerTotal){
            return true;
        }
        return false;
    }

    private  void checkAxis(int axis){
        if(axis<minPosition || axis>maxPosition){
            throw
                    new RuntimeException("X is outside board");
        }
    }

    private  void setBox(int x,int y,char lastPlayer){
        if(board[x-1][y-1]!='\0'){
            throw
                    new RuntimeException("Box is occupied");
        }else {
            board[x-1][y-1]=lastPlayer;
        }
    }

    public char nextPlayer() {
        if (lastPlayer=='X'){
            return 'O';
        }
        return 'X';
    }

    private  boolean isDraw(){
        for (int i = 0; i <SIZE ; i++) {
            for (int j = 0; j <SIZE ; j++) {
                if (board[i][j]=='\0'){
                    return false;
                }
            }
        }
        return true;
    }
}
