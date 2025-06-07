package TurtleGraphics;

public class Turtle {
    //The turtle has 3 attributes: a
    //two-dimensional location, a direction, and a pen; it is helpful, to represent the turtle location and
    //direction with double. The pen is drawing when it is down, not drawing when it is up.

    private int row;
    private int col;
    private double dir;
    public Pen pen;
    public Matrix matrix;

    public Turtle(int row, int col) {
        this.dir = 0.0;
        this.row = 0;
        this.col = 0;
        this.pen = new Pen(new BresenhamStrategy(), " # ");
        this.matrix = new Matrix(row, col);
        matrix.setCell(this.row, this.col, " @ ");
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public double getDir() {
        return this.dir;
    }

    public Matrix getMatrix() {
        return this.matrix;
    }

    public void setPosition(double newRow, double newCol) {
        if (pen.isDown()) {
            matrix.setCell(this.row, this.col, " # ");
        } else {
            matrix.setCell(this.row, this.col, "   ");
        }

        this.row = (int) Math.round(newRow);
        this.col = (int) Math.round(newCol);
        matrix.setCell(this.row, this.col, " @ ");
    }

    public void setDirection(double newDir) {
        this.dir = newDir;
    }
}
