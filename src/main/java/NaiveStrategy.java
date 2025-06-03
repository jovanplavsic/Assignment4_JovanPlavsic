public class NaiveStrategy implements DrawingStrategy{
    @Override
    public void drawLine(Matrix m, double x0, double y0, double x1, double y1) {
        // If not a vertical line
        if (x0 == x1){
            double startY = Math.min(y0, y1);
            double endY = Math.max(y0, y1);
            for (int r = (int) Math.ceil(startY); r <= (int) Math.floor(endY); r++) {
                m.setCell((int) x0, r, '#');
            }
            return;
        }

    }
}
