package TurtleGraphics;

import TurtleGraphics.Commands.Command;
import TurtleGraphics.Commands.Quit;
import TurtleGraphics.Commands.Show;

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
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            String line = input.nextLine();

            String command = line.trim().toLowerCase();
            Command commandObject = null;
            switch (command) {
                case "quit":
                    System.out.println("QUIT");
                    commandObject = new Quit();
                    running = false;
                    break;

                case "show":
                    System.out.println("SHOW");
                    commandObject = new Show();
                    break;

                case "move":
                    System.out.println("MOVE");
                    break;
                case "trace":
                    System.out.println("TRACE");
                    break;
                case "turn":
                    System.out.println("TURN");
                    break;
                default:
                    System.out.println("Commands.Command not found");
            }
        }
    }
}
