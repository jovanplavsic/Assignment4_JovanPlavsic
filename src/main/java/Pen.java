public class Pen {
    private DrawingStrategy strat;
    private char symbol;
    private boolean isDown;

    public Pen(BresenhamStrategy strat, char symbol) {
        this.strat = strat;
        this.symbol = symbol;
        this.isDown = false;
    }

    public void setStrategy(DrawingStrategy strat) {
        this.strat = strat;
    }

    public void setBrush(char brush){
        this.symbol = symbol;
    }

    public void penUp(){
        this.isDown = false;
    }

    public void penDown(){
        this.isDown = true;
    }

    public void draw(Matrix m, double x0, double y0, double x1, double y1){
        if (this.isDown) {
            strat.drawLine(m, x0, y0, x1, y1);
        }
    }
}
