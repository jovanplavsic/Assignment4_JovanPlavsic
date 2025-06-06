package TurtleGraphics.Commands;

import TurtleGraphics.Turtle;

public interface Command {
    void execute(Turtle turtle);
    void undo(Turtle turtle);
}
