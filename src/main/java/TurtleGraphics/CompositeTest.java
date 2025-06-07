package TurtleGraphics;
import TurtleGraphics.Commands.Command;


public class CompositeTest {
    public static void main(String[] args) {
        int rows = 20;
        int cols = 60;

        Turtle turtle = new Turtle(rows, cols);

        Command rect = CompositePatterns.SE350(3, 6);
        rect.execute(turtle);

        turtle.getMatrix().display();

    }
}
