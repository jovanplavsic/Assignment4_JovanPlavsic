//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {
    Turtle turtle = new Turtle(5, 5);

    @Test
    void execute() {
        Move mv = new Move(2);
        mv.execute(turtle);
        assertEquals(0, turtle.getRow());
        assertEquals(2, turtle.getCol());

        Move mv1 = new Move(100);
        mv1.execute(turtle);
        assertEquals(0, turtle.getRow());
        assertEquals(4, turtle.getCol());
    }
}