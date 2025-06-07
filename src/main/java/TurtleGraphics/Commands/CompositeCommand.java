package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;

import java.util.ArrayList;
import java.util.List;

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