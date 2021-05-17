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
}
