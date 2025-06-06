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

        double rad = Math.toRadians(turtle.getDir());
        double newCol = Math.cos(rad) * distance;
        double newRow = Math.sin(rad) * distance;

        turtle.pen.penDown();
        turtle.pen.draw(turtle.matrix, this.row, this.col, newRow, newCol);
        turtle.setPosition(this.row + newRow, this.col + newCol);
        turtle.pen.penUp();
    };

    @Override
    public void undo(Turtle turtle){};
}

