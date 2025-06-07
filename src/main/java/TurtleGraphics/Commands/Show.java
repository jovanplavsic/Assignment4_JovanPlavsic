//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;

public class Show implements Command {
    @Override
    public void execute(Turtle turtle){
        turtle.matrix.display();
    };

}

