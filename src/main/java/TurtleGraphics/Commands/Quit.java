package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;

public class Quit implements Command {
    @Override
    public void execute(Turtle turtle){
        System.out.println("Ended REPL");
    };

}
