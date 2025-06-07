package TurtleGraphics;

import TurtleGraphics.Commands.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class REPL {
    //quit: exit the TurtleGraphics.Commands.REPL
    //• show: print the current drawing to the command line
    //• move x: move the turtle with the pen up (not drawing) x distance in the current direction
    //• trace x: move the turtle with the pen down (drawing) x distance in the current direction
    //• turn x: turn the turtle by x degrees

//    private final int rows;
//    private final int cols;
//    private final TurtleGraphics.Commands.Matrix matrix;
//    private int x;
//    private int y;
//    private double dir;
//    private boolean running;
//
//    public TurtleGraphics.Commands.REPL(int rows, int cols) {
//        this.rows = rows;
//        this.cols = cols;
//        this.matrix = new TurtleGraphics.Commands.Matrix(rows, cols);
//        this.x = cols / 2;
//        this.y = rows / 2;
//        this.dir = 0.0;
//        this.running = true;
//    }


    public static void main(String[] args) {
        Turtle turtle = new Turtle(2, 2);
        Scanner input = new Scanner(System.in);
        Deque<Memento> undoStack = new ArrayDeque<>();
        Deque<Memento> redoStack = new ArrayDeque<>();

        boolean running = true;

        while (running) {
            String line = input.nextLine().trim();

            String[] inputParts = line.split("\\s+");

            String command = inputParts[0].toLowerCase();

            Command commandObject = null;


            switch (command) {
                case "quit":
                    System.out.println("QUIT");
                    running = false;
                    continue;

                case "show":
                    System.out.println("SHOW");
                    commandObject = new Show();
                    break;

                case "move":
                    System.out.println("MOVE");

                    if (inputParts.length > 1) {
                        undoStack.push(turtle.saveVersion());
                        redoStack.clear();
                        int distance = Integer.parseInt(inputParts[1]);
                        commandObject = new Move(distance);
                    } else{
                        System.out.println("No distance value.");
                        continue;
                    }
                    break;

                case "trace":
                    System.out.println("TRACE");

                    if (inputParts.length > 1) {
                        undoStack.push(turtle.saveVersion());
                        redoStack.clear();
                        int distanceT = Integer.parseInt(inputParts[1]);
                        commandObject = new Trace(distanceT);
                    } else{
                        System.out.println("No distance value.");
                        continue;
                    }
                    break;

                case "turn":
                    System.out.println("TURN");

                    if (inputParts.length > 1) {
                        undoStack.push(turtle.saveVersion());
                        redoStack.clear();
                        double angle = Double.parseDouble(inputParts[1]);
                        commandObject = new Turn(angle);
                    } else{
                        System.out.println("No angle value.");
                        continue;
                    }
                    break;

                case "undo":

                    if (!undoStack.isEmpty()) {
                        Memento current = turtle.saveVersion();
                        redoStack.push(current);

                        Memento prevState = undoStack.pop();
                        turtle.restoreVersion(prevState);
                        commandObject = new Show();

                    } else {
                        System.out.println("Nothing to undo.");
                        continue;
                    }

                    break;

                case "redo":

                    if (!redoStack.isEmpty()) {
                        Memento toRestore = redoStack.pop();
                        Memento current2 = turtle.saveVersion();
                        undoStack.push(current2);

                        turtle.restoreVersion(toRestore);
                        commandObject = new Show();
                    } else {
                        System.out.println("Nothing to redo.");
                        continue;
                    }

                    break;

                default:
                    System.out.println("Command not found");
                    continue;
            }
            commandObject.execute(turtle);

        }
        input.close();
        System.out.println("Ended Graphics Editor");
    }
}
