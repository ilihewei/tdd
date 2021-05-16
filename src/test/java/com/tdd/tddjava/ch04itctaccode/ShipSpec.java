package com.tdd.tddjava.ch04itctaccode;

import com.tdd.tddjava.ch04tictaccode.Direction;
import com.tdd.tddjava.ch04tictaccode.Location;
import com.tdd.tddjava.ch04tictaccode.Point;
import com.tdd.tddjava.ch04tictaccode.Ship;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class ShipSpec {


    private Ship ship;
    private Location location;

    @BeforeMethod
    public void beforeTest() {
        location = new Location(new Point(21, 13), Direction.NORTH);
        ship = new Ship(location);
    }


    //获取军舰的位置
    public void whenInstantedThenLocationisSet() {
        //Location location = new Location(new Point(21, 13), Direction.NONE);

       // Ship ship = new Ship(location);
        assertEquals(ship.getLocation(), location);
    }

    //前进和后退1.0
    public void givenNorthWhenMoveForwardThenYDecrease(){
        ship.moveForward();
        assertEquals(ship.getLocation().getPoint().getY(),12);
    }

    public void givenEastWhenMoveForwardThenIncrease(){
        ship.getLocation().setDirection(Direction.EAST);
        ship.moveForward();
        assertEquals(ship.getLocation().getPoint().getX(),22);

    }

}
