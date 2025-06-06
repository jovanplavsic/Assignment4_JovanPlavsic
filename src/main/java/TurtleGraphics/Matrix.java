package TurtleGraphics;

import java.util.Arrays;

public class Matrix {
    private final int rows;
    private final int cols;
    private final char[][] matrix;

    public Matrix(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Requires at least 1 row and 1 column");
        }

        this.rows = rows;
        this.cols = cols;
        this.matrix = new char[rows][cols];

//        System.out.println("Set matrix to all O");
        for (int r = 0; r < rows; r++) {
            Arrays.fill(matrix[r], 'O');
        }
    }

    public void setCell(int row, int col, char c) {
        matrix[row][col] = c;
    }


    public char getCell(int row, int col) {
        return matrix[row][col];
    }


    public void display() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }


    public void clear() {
    }

}
