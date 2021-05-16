package com.tdd.tddjava.ch04tictaccode;

public class Ship {

   private final  Location location;
    public Location getLocation() {
        return location;
    }

    public  Ship (Location location){
        this.location=location;
    }


    public void moveForward() {
        location.forward();
    }
}
