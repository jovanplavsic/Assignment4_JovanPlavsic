//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnTest {
    Turtle turtle;

    @BeforeEach
    void setup(){
        turtle = new Turtle(3, 3);
    }

    @Test
    void execute() {
        assertEquals(0, turtle.getDir());

        Turn turn = new Turn(45);
        turn.execute(turtle);

        assertEquals(45, turtle.getDir());
    }
}