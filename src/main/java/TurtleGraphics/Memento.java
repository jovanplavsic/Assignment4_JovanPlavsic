package TurtleGraphics;

public class Memento {
    private final double x;
    private final double y;
    private final double angle;
    private final String[][] matrixVersions;

    public Memento(double x, double y, double angle, String[][] canvasSnapshot) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.matrixVersions = canvasSnapshot;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }

    public String[][] getMatrixVersions() {
        return matrixVersions;
    }
}
