//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics;

/** Saves a snapshot of the amtrix, turtle and their states */
public class Memento {
    private final int row;
    private final int col;
    private final double dir;
    private final Matrix matrixVersion;

    /** Saves turtles row and column positions, direction, and matrix values */
    public Memento(int row, int col, double dir, Matrix matrixVersion) {
        this.row = row;
        this.col = col;
        this.dir = dir;
        this.matrixVersion = matrixVersion;
    }

    /** Return row of turtle */
    public int getRow() {
        return row;
    }

    /** return column of turtle */
    public int getCol() {
        return col;
    }

    /** return facing direction of turtle */
    public double getDir() {
        return dir;
    }

    /** return how matrix looked at the moment of memento instantiation */
    public Matrix getMatrixVersion() {
        return matrixVersion;
    }
}
