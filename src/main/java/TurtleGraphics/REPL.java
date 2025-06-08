//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics;

import TurtleGraphics.Commands.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class REPL {

    public static void main(String[] args) {
        Turtle turtle = new Turtle(10, 10);
        Scanner input = new Scanner(System.in);

        /**
         * Keep track of previous versions
         * */
        Deque<Memento> undoStack = new ArrayDeque<>();
        Deque<Memento> redoStack = new ArrayDeque<>();

        boolean running = true;

        while (running) {
            String line = input.nextLine().trim();

            String[] inputParts = line.split("\\s+");

            String command = inputParts[0].toLowerCase();

            Command commandObject = null;


            /**
             * Filter through command options to call right one
             * */
            switch (command) {
                case "quit":
                    /**
                     * Quit REPL
                     * */
                    running = false;
                    continue;

                case "show":
                    commandObject = new Show();
                    break;

                case "move":
                    /**
                     * Move turtle without tracing
                     * */

                    if (inputParts.length > 1) {
                        undoStack.push(turtle.saveVersion());
                        redoStack.clear();
                        int distance = Integer.parseInt(inputParts[1]);
                        commandObject = new Move(distance);
                    } else {
                        System.out.println("No distance value.");
                        continue;
                    }
                    break;

                case "trace":
                    /**
                     * Trace movement of turtle
                     * */

                    if (inputParts.length > 1) {
                        undoStack.push(turtle.saveVersion());
                        redoStack.clear();
                        int distanceT = Integer.parseInt(inputParts[1]);
                        commandObject = new Trace(distanceT);
                    } else {
                        System.out.println("No distance value.");
                        continue;
                    }
                    break;

                case "turn":
                    /**
                     * Update turtles direction
                     * */

                    if (inputParts.length > 1) {
                        undoStack.push(turtle.saveVersion());
                        redoStack.clear();
                        double angle = Double.parseDouble(inputParts[1]);
                        commandObject = new Turn(angle);
                    } else {
                        System.out.println("No angle value.");
                        continue;
                    }
                    break;

                case "undo":
                    /**
                     * Go back in undo stack and add to redo stack
                     * */
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
