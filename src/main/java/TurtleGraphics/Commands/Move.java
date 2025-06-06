package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;

// row = y
// col = x

public class Move implements Command {
    private final int distance;
    private int row;
    private int col;

    public Move(int distance){
        this.distance = distance;
    }

    @Override
    public void execute(Turtle turtle){
        this.row = turtle.getRow();
        this.col = turtle.getCol();

        double rad = Math.toRadians(turtle.getDir());
        double newCol = Math.cos(rad) * distance;
        double newRow = Math.sin(rad) * distance;


        turtle.setPosition(this.row + newRow, this.col + newCol);
    };

    @Override
    public void undo(Turtle turtle){};
}

