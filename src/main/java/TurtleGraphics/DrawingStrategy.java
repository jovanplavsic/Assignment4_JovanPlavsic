//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics;

public interface DrawingStrategy {
    void drawLine(Matrix m, double x0, double y0, double x1, double y1);
    String getStrat();
}
