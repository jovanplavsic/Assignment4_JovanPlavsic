//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

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
