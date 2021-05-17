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
     * 每次修改实现代码都再次运行所有的测试（引入jenkins的意义）
     * 这确保对代码所做的修改不会带来任何意外的副作用。
     */

    /**
     * 缺陷：
     * 如果外部代码发生变化，将需要修改很多的规范，而理想的情况下，单元被修改是
     */
    //前进
    public void whenMoveForwardThenForward(){
        Location expected = this.location.copy();
        expected.forward();
        ship.moveForward();
        assertEquals(ship.getLocation(),expected);
    }

    //回退
    public void whenMoveBackwardThenBackward(){
        Location expected=this.location.copy();
        expected.backward();
        ship.moveBackWard();
        assertEquals(ship.getLocation(),expected);

    }

    //左转

    public void whenTurnLeftThenLeftward(){
        Location expected=this.location.copy();
        expected.turnLeft();
        ship.turnLeft();
        assertEquals(ship.getLocation(),expected);
    }

    //右转

    public void whenTurnRightThenRight(){
        Location expected=this.location.copy();
        expected.turnRight();
        ship.turnRight();
        assertEquals(ship.getLocation(),expected);
    }


    /**
     * 前面所做的一切都非常的简单，因为有辅助类提供了所有的功能。这个练习让你不去测试最终的结果，而是专注当前要开发的单元，
     * 这是为了加强信任，因为我们必需信任他人编写的代码（辅助类），
     * 从这个需求开始，你将必需信任自己编写的代码，我们将继续前面的做法，编写规范，运行测试并发现他们以失败告终，在编写实现，
     * 运行测试并发现测试通过；最后，对我们认为存在改进空间的代码进行重构，
     * 同时，继续继承这样的思路，即对单元（方法）进行测试时，不要过多的考虑他将调用的方法或类
     */

    public void whenReceiveCommandsFThenForward(){
        Location expected=location.copy();
        expected.forward();
        ship.receiveCommand("f");
        assertEquals(ship.getLocation(),expected);
    }

    /**
     * kiss 原则
     *应编写尽可能简单的代码，只要让测试能够通过即可，这颗确保设计越轻越清晰，并避免多余的功能
     */

    public void whenReceiveCommandsFThenAllAreExecuted(){
        Location expected=location.copy();
        expected.turnRight();
        expected.forward();
        expected.turnLeft();
        expected.backward();
        ship.receiveCommand("rflb");
        assertEquals(ship.getLocation(),expected);
    }

}
