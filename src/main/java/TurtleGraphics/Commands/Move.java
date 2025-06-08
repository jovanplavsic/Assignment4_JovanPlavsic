//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;

// row = y
// col = x

/** Represents turtle moving from one location to another on matrix without leaving a trace */
public class Move implements Command {
    private final int distance;
    private int row;
    private int col;

    public Move(int distance) {
        this.distance = distance;
    }


    @Override
    public void execute(Turtle turtle) {

        /** Get current position */
        this.row = turtle.getRow();
        this.col = turtle.getCol();

        /** Calculate next location based on direction*/
        double rad = Math.toRadians(turtle.getDir());
        double newCol = this.col + Math.cos(rad) * distance;
        double newRow = this.row + Math.sin(rad) * distance;

        int maxRow = turtle.getMatrix().rows - 1;
        int maxCol = turtle.getMatrix().cols - 1;

        /** Stop at edge of matrix if out of bounds */
        newRow = Math.max(0, Math.min(newRow, maxRow));
        newCol = Math.max(0, Math.min(newCol, maxCol));

        /** Update turtles position to new location
         *  Lift pen up to communicate to future commands to not leave mark
         * */
        turtle.setPosition(newRow, newCol);
        turtle.pen.penUp();
    }
}

