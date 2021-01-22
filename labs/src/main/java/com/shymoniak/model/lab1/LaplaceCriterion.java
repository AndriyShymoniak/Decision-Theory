package com.shymoniak.model.lab1;

import com.shymoniak.tools.MatrixActions;

import java.util.Arrays;

/**
 * Sums all values in each row of 2d matrix.
 * Divides them by the amount of elements in the row.
 * The row which the highest sum value is the best option.
 */
public class LaplaceCriterion extends MatrixSolver {

    public LaplaceCriterion(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[] bestSolution() {
        MatrixActions matrixActions = new MatrixActions();

        // Sum all values in each row of matrix
        int[] sumOfRows = new int[getRowsNumber()];
        for (int i = 0; i < getRowsNumber(); i++) {
            for (int j = 0; j < getColsNumber(); j++) {
                sumOfRows[i] = Arrays.stream(matrix[i]).sum()/ getColsNumber();
            }
        }
        System.out.print("Summing divided values for each row: ");
        System.out.println(Arrays.toString(sumOfRows));

        // Get the highest value of row sums
        int highest = matrixActions.findHighestIn1D(sumOfRows);
        System.out.println("The highest value of them is: " + highest);

        // Return the row which has the highest sum value
        return matrix[matrixActions.getIndexIn1D(highest,sumOfRows)];
    }
}