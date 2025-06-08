//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics;

public class Turtle {
    /**
     * The turtle has 3 attributes: a
     * two-dimensional location, a direction, and a pen; it is helpful, to represent the turtle location
     * and direction with double. The pen is drawing when it is down, not drawing when it is up.
     * */


    public int row;
    public int col;
    public double dir;
    public Pen pen;
    public Matrix matrix;
    public String prevVal = "   ";

    /**
     * @rows and @cols define how big the matrix is
     * Turtle always starts at (0, 0), NaiveStrategy, with " # " brush
     * Turtle is represented as " @ " on matrix
     * prevVal keeps track of waht value is supposed to be underneath turtle
     * */
    public Turtle(int rows, int cols) {
        this.dir = 0.0;
        this.row = 0;
        this.col = 0;
        this.pen = new Pen(new NaiveStrategy(), " # ");
        this.matrix = new Matrix(rows, cols);
        matrix.setCell(this.row, this.col, " @ ");
    }

    /**
     * Column, Row, Dir, getters and setters
     * */
    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public double getDir() {
        return this.dir;
    }

    public void setDirection(double newDir) {
        this.dir = newDir;
    }

    public Matrix getMatrix() {
        return this.matrix;
    }

    /**
     * Update turtle location
     * Set previous location to value that was before it
     * update prevValue
     * */
    public void setPosition(double newRow, double newCol) {
        matrix.setCell(this.row, this.col, prevVal);

        this.row = (int) Math.round(newRow);
        this.col = (int) Math.round(newCol);

        if (this.pen.isDown()){
            prevVal = " # ";
        } else{
           prevVal = this.getMatrix().getCell(this.row, this.col);
        }

        matrix.setCell(this.row, this.col, " @ ");
    }

    /**
     * Save a memento (snapshot) of matrix at point of being called
     * */
    public Memento saveVersion() {

        String[][] copy = new String[matrix.rows][matrix.cols];

        for (int r = 0; r < matrix.rows; r++) {
            for (int c = 0; c < matrix.cols; c++) {
                copy[r][c] = matrix.getCell(r, c);
            }
        }
        Matrix copyMatrix = new Matrix(matrix.rows, matrix.cols, copy);
        return new Memento(this.row, this.col, this.dir, copyMatrix);
    }

    /**
     * Restore previous version of matrix that is passed through to it as argument
     * */
    public void restoreVersion(Memento version){
        this.col = version.getCol();
        this.row = version.getRow();
        this.dir = version.getDir();
        this.matrix = version.getMatrixVersion();
    }
}
