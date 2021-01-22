package com.shymoniak.model.lab1;

import com.shymoniak.tools.MatrixActions;

import java.util.Arrays;

/**
 * Using special formula, multiplies coefficients of cols by col values
 * in each row and then adds them: A11*Q1 + A12*Q2 + ... + Anm*Qm.
 * The row which has the highest value, calculated with formula is the best option
 */
public class BayesLaplaceCriterion extends MatrixSolver {
    private double[] coefficients;

    public BayesLaplaceCriterion(int[][] matrix, double[] coefficients) {
        this.matrix = matrix;
        this.coefficients = coefficients;
    }

    public int[] bestSolution(){
        MatrixActions matrixActions = new MatrixActions();

        // Calculate special values
        double[] specialValues = new double[getRowsNumber()];
        for (int i = 0; i < specialValues.length; i++) {
            for (int j = 0; j < getColsNumber(); j++) {
                specialValues[i] += coefficients[j]*matrix[i][j];
            }
        }
        System.out.println("Formula: [A11*k1 + A12*k2 + A13*k3]");
        System.out.print("Values calculated with formula for each row: ");
        System.out.println(Arrays.toString(specialValues));

        // Get the highest number in special values
        double highest = matrixActions.findHighestIn1D(specialValues);

        // Return the row with the highest value
        return matrix[matrixActions.getIndexIn1D(highest,specialValues)];
    }
}