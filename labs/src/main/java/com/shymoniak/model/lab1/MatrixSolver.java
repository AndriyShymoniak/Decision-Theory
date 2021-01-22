package com.shymoniak.model.lab1;

public class MatrixSolver {
    public int[][] matrix;

    public int getRowsNumber() {
        return matrix[0].length;
    }

    public int getColsNumber() {
        return matrix.length;
    }
}