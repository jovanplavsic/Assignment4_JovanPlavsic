package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;

// row = y
// col = x

public class Move implements Command {
    private final int distance;
    private int row;
    private int col;

    public Move(int distance) {
        this.distance = distance;
    }

    @Override
    public void execute(Turtle turtle) {

        this.row = turtle.getRow();
        this.col = turtle.getCol();

        double rad = Math.toRadians(turtle.getDir());
        double newCol = this.col + Math.cos(rad) * distance;
        double newRow = this.row + Math.sin(rad) * distance;

        int maxRow = turtle.getMatrix().rows - 1;
        int maxCol = turtle.getMatrix().cols - 1;

        newRow = Math.max(0, Math.min(newRow, maxRow));
        newCol = Math.max(0, Math.min(newCol, maxCol));

        turtle.setPosition(newRow, newCol);
        turtle.pen.penUp();
    }
}

