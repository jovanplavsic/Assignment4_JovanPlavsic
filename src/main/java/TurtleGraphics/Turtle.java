package TurtleGraphics;

public class Turtle {
    //The turtle has 3 attributes: a
    //two-dimensional location, a direction, and a pen; it is helpful, to represent the turtle location and
    //direction with double. The pen is drawing when it is down, not drawing when it is up.

    private int row;
    private int col;
    private double dir;
    private Pen pen;
    public Matrix matrix;

    public Turtle(int row, int col) {
        this.dir = 0.0;
        this.row = row;
        this.col = col;
        this.pen = new Pen(new BresenhamStrategy(), '#');
        this.matrix = new Matrix(row, col);
    }

    public int getCol(){
        return this.col;
    }

    public int getRow(){
        return this.row;
    }

    public double getDir(){
        return this.dir;
    }

    public void setPosition(double newRow, double newCol){
        this.row = (int) Math.round(newRow);
        this.col = (int) Math.round(newCol);
    }
}
