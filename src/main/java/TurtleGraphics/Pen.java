package TurtleGraphics;

public class Pen {
    private DrawingStrategy strat;
    private String symbol;
    private boolean isDown;

    public Pen(DrawingStrategy strat, String symbol) {
        this.strat = strat;
        this.symbol = symbol;
        this.isDown = false;
    }

    public void setStrategy(DrawingStrategy strat) {
        this.strat = strat;
    }

    public String getStrategy(){
        return this.strat.getStrat();
    }

    public void setBrush(String brush){
        this.symbol = brush;
    }

    public String getBrush(){
        return this.symbol;
    }

    public void penUp(){
        this.isDown = false;
    }

    public void penDown(){
        this.isDown = true;
    }

    public boolean isDown(){
        return this.isDown;
    }

    // row
    public void draw(Matrix m, double row0, double col0, double row1, double col1){
        if (this.isDown) {
            strat.drawLine(m, col0, row0, col1, row1);
        }
    }
}
