//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics;

/** Applies drawing strategy */
public class Pen {
    private DrawingStrategy strat;
    private String symbol;
    private boolean isDown;

    /** Can be either Bresenham or Naive strats */
    public Pen(DrawingStrategy strat, String symbol) {
        this.strat = strat;
        this.symbol = symbol;
        this.isDown = false;
    }

    /** Set strategy */
    public void setStrategy(DrawingStrategy strat) {
        this.strat = strat;
    }

    /** return text representation of strat (name)*/
    public String getStrategy(){
        return this.strat.getStrat();
    }

    /** Set brush symbol (# or whatever you want filled in cells to be) */
    public void setBrush(String brush){
        this.symbol = brush;
    }

    /** Return brush symbol */
    public String getBrush(){
        return this.symbol;
    }

    /** Lift pen to communicate not tracing */
    public void penUp(){
        this.isDown = false;
    }

    /** Put down pen to indicate tracing */
    public void penDown(){
        this.isDown = true;
    }

    /** Returns true if pen is down */
    public boolean isDown(){
        return this.isDown;
    }

    /** applies selected strategy */
    public void draw(Matrix m, double row0, double col0, double row1, double col1){
        if (this.isDown) {
            strat.drawLine(m, col0, row0, col1, row1);
        }
    }
}
