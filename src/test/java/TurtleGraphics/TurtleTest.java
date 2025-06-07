package TurtleGraphics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurtleTest {

    Turtle turtle = new Turtle(10, 10);


    @Test
    void getCol() {
        assertEquals(0, turtle.getCol());
        turtle.setPosition(0, 5);
        assertEquals(5, turtle.getCol());
    }

    @Test
    void getRow() {
        assertEquals(0, turtle.getRow());
        turtle.setPosition(7, 0);
        assertEquals(7, turtle.getRow());
    }

    @Test
    void getDir() {
        assertEquals(0.0, turtle.getDir());
    }

    @Test
    void getMatrix() {
        Matrix m = turtle.getMatrix();
        assertNotNull(m);
        assertEquals(10, m.cols);
        assertEquals(10, m.rows);
    }

    @Test
    void setPosition() {
        turtle.setPosition(3, 4);
        assertEquals(3, turtle.getRow());
        assertEquals(4, turtle.getCol());

        assertEquals(" @ ", turtle.getMatrix().getCell(3, 4));
        turtle.setPosition(4, 5);
        assertEquals("   ", turtle.getMatrix().getCell(3, 4));
    }

    @Test
    void setDirection() {
        turtle.setDirection(90.0);
        assertEquals(90.0, turtle.getDir());
    }

    @Test
    void saveAndRestoreVersion() {
        turtle.setPosition(2, 2);
        turtle.setDirection(30.0);
        Memento m = turtle.saveVersion();

        turtle.setPosition(5, 5);
        turtle.setDirection(60.0);

        turtle.restoreVersion(m);
        assertEquals(2, turtle.getRow());
        assertEquals(2, turtle.getCol());
        assertEquals(30.0, turtle.getDir());
    }
}