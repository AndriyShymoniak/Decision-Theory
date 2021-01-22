package com.shymoniak.model.lab1.criterias;

import com.shymoniak.tools.MatrixActions;

import java.util.Arrays;

/**
 * Finds the lowest and the highest values in each row of 2d matrix
 * Uses the special formula: coefficient * min + (1 - coefficient) * max
 * The row which has the highest value, calculated with formula is the best option
 */
public class HurwitzCriteria extends MatrixSolver {

    private double coefficient;

    public HurwitzCriteria(int[][] matrix, double coefficient) {
        this.matrix = matrix;
        this.coefficient = coefficient;
    }

    public int[] bestSolution() {
        MatrixActions matrixActions = new MatrixActions();

        // Find lower values in each row of matrix
        int[] minOfRows = new int[getRows()];
        for (int i = 0; i < getRows(); i++) {
            minOfRows[i] = matrixActions.findLowestIn1D(matrix[i]);
        }
        System.out.print("The lowest values of each row: ");
        System.out.println(Arrays.toString(minOfRows));

        // Find higher values in each row of matrix
        int[] maxOfRows = new int[getRows()];
        for (int i = 0; i < getRows(); i++) {
            maxOfRows[i] = matrixActions.findHighestIn1D(matrix[i]);
        }
        System.out.print("The highest values of each row: ");
        System.out.println(Arrays.toString(maxOfRows));

        // Calculate special value
        double[] specialValues = new double[getRows()];
        for (int i = 0; i < specialValues.length; i++) {
            specialValues[i] = coefficient * minOfRows[i] + (1 - coefficient) * maxOfRows[i];
        }
        System.out.println("Formula: [k*min + (1-k)*max]");

        System.out.print("The values calculated with formula for each row: ");
        System.out.println(Arrays.toString(specialValues));

        // Get the highest number in special values
        double highest = matrixActions.findHighestIn1D(specialValues);

        // Return the row which has the highest special value
        return matrix[matrixActions.getIndexIn1D(highest,specialValues)];
    }
}
