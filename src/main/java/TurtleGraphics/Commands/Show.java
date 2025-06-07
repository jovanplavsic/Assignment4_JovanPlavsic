package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;

public class Show implements Command {
    @Override
    public void execute(Turtle turtle){
        turtle.matrix.display();
    };

}

