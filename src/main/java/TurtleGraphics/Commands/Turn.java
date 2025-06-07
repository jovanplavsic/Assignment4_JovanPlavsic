//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;

public class Turn implements Command {
    private final double angle;

    public Turn(double angle){
        this.angle = angle;
    }

    @Override
    public void execute(Turtle turtle){
        double newDir = (turtle.getDir() + angle) % 360.0;
        turtle.setDirection(newDir);
    }

}

