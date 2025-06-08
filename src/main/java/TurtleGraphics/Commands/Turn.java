//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;

/** Turn turtle clockwise direction using degrees */
public class Turn implements Command {
    private final double angle;

    public Turn(double angle){
        this.angle = angle;
    }

    /** Can only rotate clockwise
     *  Converts degrees to 0-1 value
     *  0 is facing East (Right)
     * */
    @Override
    public void execute(Turtle turtle){
        double newDir = (turtle.getDir() + angle) % 360.0;
        turtle.setDirection(newDir);
    }

}

