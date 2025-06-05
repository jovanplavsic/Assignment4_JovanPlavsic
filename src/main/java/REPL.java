import java.util.Scanner;

public class REPL {
    //quit: exit the REPL
    //• show: print the current drawing to the command line
    //• move x: move the turtle with the pen up (not drawing) x distance in the current direction
    //• trace x: move the turtle with the pen down (drawing) x distance in the current direction
    //• turn x: turn the turtle by x degrees

//    private final int rows;
//    private final int cols;
//    private final Matrix matrix;
//    private int x;
//    private int y;
//    private double dir;
//    private boolean running;
//
//    public REPL(int rows, int cols) {
//        this.rows = rows;
//        this.cols = cols;
//        this.matrix = new Matrix(rows, cols);
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
            System.out.println(line);
        }
    }
}
