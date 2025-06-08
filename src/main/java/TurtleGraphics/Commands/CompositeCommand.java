//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;

import java.util.ArrayList;
import java.util.List;

/** Collects multiple commands to implement when execute() is called on this object */
public class CompositeCommand implements Command {
    private final List<Command> subCommands;

    public CompositeCommand(List<Command> subCommands) {
        this.subCommands = new ArrayList<>(subCommands);
    }

    @Override
    public void execute(Turtle turtle) {
        for (Command cmd : subCommands) {
            cmd.execute(turtle);
        }
    }
}