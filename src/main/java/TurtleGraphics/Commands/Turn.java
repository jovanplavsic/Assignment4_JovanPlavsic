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

