package com.shymoniak.lab1.criterias;

import com.shymoniak.tools.MatrixActions;

/**
 * Finds the lowest values in each row of 2d matrix
 * The row which the highest lower value is the best option
 */
public class WaldCriteria extends MatrixSolver{

    public WaldCriteria(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[] bestSolution() {
        MatrixActions matrixActions = new MatrixActions();

        // Find lower values in each row of matrix
        int[] minOfRows = new int[getRows()];
        for (int i = 0; i < getRows(); i++) {
            minOfRows[i] = matrixActions.findLowestIn1D(matrix[i]);
        }

        // Get the highest of all lower values
        int highest = matrixActions.findHighestIn1D(minOfRows);

        // Return the row which has the highest lower value
        return matrix[matrixActions.getIndexOfRow2D(highest, matrix)];
    }
}
