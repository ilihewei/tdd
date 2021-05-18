package com.tdd.tddjava.ch04tictaccode;

public class Ship {

   private final  Location location;
   private  Planet planet;

    public Planet getPlanet() {
        return planet;
    }

    public Location getLocation() {
        return location;
    }

   // public  Ship (Location location){
    //    this.location=location;
  //  }
    public  Ship(Location location,Planet planet){
        this.location=location;
        this.planet=planet;
    }


    public boolean moveForward() {
        return location.forward(planet.getMax());
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
