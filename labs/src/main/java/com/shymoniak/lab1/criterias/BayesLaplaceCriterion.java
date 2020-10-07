package com.shymoniak.lab1.criterias;

import com.shymoniak.tools.MatrixActions;

/**
 * Using special formula, multiplies coefficients of cols by col values
 * in each row and then adds them: A11*Q1 + A12*Q2 + ... + Anm*Qm
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

        // Calculate special value
        double[] specialValues = new double[getRows()];
        for (int i = 0; i < specialValues.length; i++) {
            for (int j = 0; j < getCols(); j++) {
                specialValues[i] += coefficients[j]*matrix[i][j];
            }
        }
        System.out.println("Formula: [A11*k1 + A12*k2 + A13*k3]");

        System.out.print("The values calculated with formula for each row: ");
        matrixActions.print(specialValues);

        // Get the highest number in special values
        double highest = matrixActions.findHighestIn1D(specialValues);

        // Return the row which has the highest special value
        return matrix[matrixActions.getIndex1D(highest,specialValues)];
    }
}
