//------------------------------------------------------
// Assignment 4
// Written by: Jovan Plavsic 230417
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

package TurtleGraphics;

import java.util.Arrays;

/** Represents a canvas to draw on in which each pixel is a cell in the matrix */
public class Matrix {
    public final int rows;
    public final int cols;
    private final String[][] matrix;

    public Matrix(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Requires at least 1 row and 1 column");
        }

        this.rows = rows;
        this.cols = cols;
        this.matrix = new String[rows][cols];

        for (int r = 0; r < rows; r++) {
            Arrays.fill(matrix[r], "   ");
        }
    }

    public Matrix(int rows, int cols, String[][] array) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Requires at least 1 row and 1 column");
        }

        this.rows = rows;
        this.cols = cols;
        this.matrix = array;
    }

    /** Set cell value to new string */
    public void setCell(int row, int col, String c) {
        matrix[row][col] = c;
    }


    /** Geet string (value) that is in a cell given its coordinates*/
    public String getCell(int row, int col) {
        return matrix[row][col];
    }


    /** Print matrix to show canvas */
    public void display() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }


}
