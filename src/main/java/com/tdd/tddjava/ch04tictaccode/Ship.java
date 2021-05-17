package com.tdd.tddjava.ch04tictaccode;

public class Ship {

   private final  Location location;
    public Location getLocation() {
        return location;
    }

    public  Ship (Location location){
        this.location=location;
    }


    public boolean moveForward() {
        return location.forward();
    }

    public boolean moveBackWard() {
        return  location.backward();
    }

    public void turnLeft() {
         location.turnLeft();
    }

    public void turnRight() {
        location.turnRight();
    }

    public void receiveCommand(String operations) {
        //1.0 最简版本
//        turnRight();
//        moveForward();
//        turnLeft();
//        moveBackWard();

        //最终版本
        for (char command:operations.toCharArray()){
            switch (command){
                case 'f':
                    moveForward();
                    break;
                case 'b':
                    moveBackWard();
                    break;
                case 'l':
                    turnLeft();
                    break;
                case  'r':
                    turnRight();
                    break;
            }
        }


    }
}
