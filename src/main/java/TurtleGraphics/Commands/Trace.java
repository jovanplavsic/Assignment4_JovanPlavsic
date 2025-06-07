package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;

public class Trace implements Command {
    private final int distance;
    private int row;
    private int col;

    public Trace(int distance){
        this.distance = distance;
    }

    @Override
    public void execute(Turtle turtle){
        this.row = turtle.getRow();
        this.col = turtle.getCol();

        double radian = Math.toRadians(turtle.getDir());
        double deltaC = Math.cos(radian) * distance;
        double deltaR = Math.sin(radian) * distance;

        double newCol = Math.round(this.col + deltaC);
        double newRow = Math.round(this.row + deltaR);

        int maxRow = turtle.getMatrix().rows - 1;
        int maxCol = turtle.getMatrix().cols - 1;

        newRow = Math.max(0, Math.min(newRow, maxRow));
        newCol = Math.max(0, Math.min(newCol, maxCol));

        turtle.pen.penDown();
        turtle.pen.draw(turtle.matrix, this.col, this.row, newCol, newRow);
        turtle.setPosition(newRow, newCol);
    }

}

