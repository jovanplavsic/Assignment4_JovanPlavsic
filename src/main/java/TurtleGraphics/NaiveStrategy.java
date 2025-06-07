//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics;

public class NaiveStrategy implements DrawingStrategy {
    @Override
    public void drawLine(Matrix m, double x0, double y0, double x1, double y1) {
        // If a vertical line
        if (x0 == x1) {
            double startY = Math.min(y0, y1);
            double endY = Math.max(y0, y1);
            for (int r = (int) Math.ceil(startY); r <= (int) Math.floor(endY); r++) {
                m.setCell((int) x0, r, " # ");
            }
            return;
        }

        // If not a vertical line
        double slope = (y1 - y0) / (x1 - x0);
        double startX = Math.min(x0, x1);
        double endX = Math.max(x0, x1);

        for (int c = (int) Math.ceil(startX); c <= (int) Math.floor(endX); c++) {
            double y = y0 + slope * (c - x0);
            m.setCell(c, (int) Math.round(y), " # ");
        }
        m.display();
    }

    @Override
    public String getStrat(){
        return "Naive";
    }
}
