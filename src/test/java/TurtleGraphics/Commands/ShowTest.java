package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ShowTest {
    Turtle turtle;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        turtle = new Turtle(2, 2);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void execute() {
        Show show = new Show();
        show.execute(turtle);

        String expected =
                " @    " + System.lineSeparator() +
                "      " + System.lineSeparator();
        assertEquals(expected, outContent.toString());
    }

    @Test
    void afterMove(){
        Move move = new Move(3);
        move.execute(turtle);

        Show show = new Show();
        show.execute(turtle);

        String expected1 =
                "    @ " + System.lineSeparator() +
                "      " + System.lineSeparator();
        assertEquals(expected1, outContent.toString());
    }
}