//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;

/** Move turtle and trace it's path*/
public class Trace implements Command {
    private final int distance;
    private int row;
    private int col;

    public Trace(int distance){
        this.distance = distance;
    }

    @Override
    public void execute(Turtle turtle){
        /** Get current position */
        this.row = turtle.getRow();
        this.col = turtle.getCol();

        /** Calculate next location based of direction */
        double radian = Math.toRadians(turtle.getDir());
        double deltaC = Math.cos(radian) * distance;
        double deltaR = Math.sin(radian) * distance;

        double newCol = Math.round(this.col + deltaC);
        double newRow = Math.round(this.row + deltaR);

        int maxRow = turtle.getMatrix().rows - 1;
        int maxCol = turtle.getMatrix().cols - 1;

        /** Save old position to revert to previous val after moving */
        int oldRow = this.row;
        int oldCol = this.col;

        /** Stop at edge of matrix if out of bounds */
        newRow = Math.max(0, Math.min(newRow, maxRow));
        newCol = Math.max(0, Math.min(newCol, maxCol));

        /** Update turtles position to new location
         *  Put pen down to communicate to draw() and future commands
         *  Update position again to same (new) location to draw turtle (@)
         * */
        turtle.setPosition(newRow, newCol);
        turtle.pen.penDown();
        turtle.pen.draw(turtle.matrix, oldCol, oldRow, newCol, newRow);
        turtle.setPosition(newRow, newCol);
    }

}

