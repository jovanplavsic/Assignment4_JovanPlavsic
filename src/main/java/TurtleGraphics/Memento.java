package TurtleGraphics;

public class Memento {
    private final double row;
    private final double col;
    private final double angle;
    private final String[][] matrixVersions;

    public Memento(int row, int col, double angle, String[][] canvasSnapshot) {
        this.row = row;
        this.col = col;
        this.angle = angle;
        this.matrixVersions = canvasSnapshot;
    }

    public double getRow() {
        return row;
    }

    public double getCol() {
        return col;
    }

    public double getAngle() {
        return angle;
    }

    public String[][] getMatrixVersions() {
        return matrixVersions;
    }
}
