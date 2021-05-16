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

    public void whenInstantedThenLocationisSet() {
        //Location location = new Location(new Point(21, 13), Direction.NONE);

       // Ship ship = new Ship(location);
        assertEquals(ship.getLocation(), location);
    }

}
