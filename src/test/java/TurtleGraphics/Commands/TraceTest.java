//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TraceTest {
    Turtle turtle;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        turtle = new Turtle(3, 3);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void execute() {
        Trace trace = new Trace(3);
        trace.execute(turtle);

        Show show2 = new Show();
        show2.execute(turtle);

        String expected1 =
                " #  #  @ " + System.lineSeparator() +
                "         " + System.lineSeparator() +
                "         " + System.lineSeparator();
        assertEquals(expected1, outContent.toString());
    }

}