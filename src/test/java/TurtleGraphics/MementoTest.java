//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MementoTest {


    @Test
    void getRowColAndMatrix() {
        Turtle trt = new Turtle(3, 3);
        Matrix mtx = trt.getMatrix();
        mtx.setCell(1, 1, " X ");

        Memento memento = new Memento(trt.getRow(), trt.getCol(), trt.getDir(), trt.getMatrix());

        String val1 = memento.getMatrixVersion().getCell(0, 0);
        assertEquals(" @ ", val1);

        String val2 = memento.getMatrixVersion().getCell(1, 1);
        assertEquals(" X ", val2);

        // Test tht original matrix doesn't affect memento copy
        trt.setPosition(2, 2);
        assertEquals(memento.getRow(), 0);
        assertEquals(memento.getCol(), 0);
    }

}