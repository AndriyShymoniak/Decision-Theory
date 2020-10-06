package com.shymoniak.lab1.criterias;

import com.shymoniak.tools.MatrixActions;

import java.util.Arrays;

/**
 * Sums all values in each row of 2d matrix
 * The row which the highest sum value is the best option
 */
public class LaplaceCriterion extends MatrixSolver {

    public LaplaceCriterion(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[] bestSolution() {
        MatrixActions matrixActions = new MatrixActions();

        // Sum all values in each row of matrix
        int[] sumOfRows = new int[getRows()];
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                sumOfRows[i] = Arrays.stream(matrix[i]).sum();
            }
        }

        // Get the highest value of row sums
        int highest = matrixActions.findHighestIn1D(sumOfRows);

        // Return the row which has the highest sum value
        return matrix[matrixActions.getIndex1D(highest,sumOfRows)];
    }
}
