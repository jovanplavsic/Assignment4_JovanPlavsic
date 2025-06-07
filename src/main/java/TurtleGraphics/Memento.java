package TurtleGraphics;

public class Memento {
    private final int row;
    private final int col;
    private final double dir;
    private final Matrix matrixVersion;

    public Memento(int row, int col, double dir, Matrix matrixVersion) {
        this.row = row;
        this.col = col;
        this.dir = dir;
        this.matrixVersion = matrixVersion;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public double getDir() {
        return dir;
    }

    public Matrix getMatrixVersion() {
        return matrixVersion;
    }
}
