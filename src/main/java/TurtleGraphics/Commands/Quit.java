package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;

public class Quit implements Command {
    @Override
    public void execute(Turtle turtle){
        System.out.println("Ended Graphics Editor");
    };

    @Override
    public void undo(Turtle turtle){};
}
