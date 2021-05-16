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
    //向南
    public void givenNorthWhenMoveForwardThenYDecrease(){
        ship.moveForward();
        assertEquals(ship.getLocation().getPoint().getY(),12);
    }

    //向西
    public void givenEastWhenMoveForwardThenIncrease(){
        ship.getLocation().setDirection(Direction.EAST);
        ship.moveForward();
        assertEquals(ship.getLocation().getPoint().getX(),22);
    }

    /**
     *
     * warnging：
     *
     * 如果这样做，你至少还需编写两个规范，他们呢分别与军舰朝南和向西相关
     * 然后，不应该这样编写单元测试。大多数ut新手都会落入这样的陷阱，即指定方法的结果时，牵涉到它使用的方法，类
     * 和库的内部工作原理。这种做法在很多层面都存在问题
     *
     *
     * 当前规范的单元包含外部代码时，应考虑这样一点，（至少在这里应该如此），即外部代码应景经过测试。我们知道外部代码没有问题，
     * 因为每次修改后，我们都运行了所有的测试
     *
     * 每次修改实现代码都再次运行所有的测试
     * 这确保对代码所做的修改不会带来任何意外的副作用。
     */

}
