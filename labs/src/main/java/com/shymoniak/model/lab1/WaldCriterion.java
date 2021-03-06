package com.shymoniak.model.lab1;

import com.shymoniak.tools.MatrixActions;

import java.util.Arrays;

/**
 * Finds the lowest values in each row of 2d matrix
 * The row which the highest lower value is the best option
 */
public class WaldCriterion extends MatrixSolver{

    public WaldCriterion(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[] bestSolution() {
        MatrixActions matrixActions = new MatrixActions();

        // Find the lowest value in each row of matrix
        int[] minOfRows = new int[getRowsNumber()];
        for (int i = 0; i < getRowsNumber(); i++) {
            minOfRows[i] = matrixActions.findLowestIn1D(matrix[i]);
        }
        System.out.print("Each row minimum values: ");
        System.out.println(Arrays.toString(minOfRows));

        // Get the highest of all lower values
        int highest = matrixActions.findHighestIn1D(minOfRows);
        System.out.println("So the highest lower value is: " + highest);

        // Return a row with the highest lower value
        return matrix[matrixActions.getIndexOfRowIn2D(highest, matrix)];
    }
}