package com.shymoniak.tools;

public class MatrixActions {

    public int findLowestIn1D(int[] matrix) {
        int minValue = matrix[0];
        for (int i = 0; i < matrix.length; i++) {
            if (minValue > matrix[i]) {
                minValue = matrix[i];
            }
        }
        return minValue;
    }

    public int findHighestIn1D(int[] matrix) {
        int maxValue = matrix[0];
        for (int i = 0; i < matrix.length; i++) {
            if (maxValue < matrix[i]) {
                maxValue = matrix[i];
            }
        }
        return maxValue;
    }

    public double findHighestIn1D(double[] matrix) {
        double maxValue = matrix[0];
        for (int i = 0; i < matrix.length; i++) {
            if (maxValue < matrix[i]) {
                maxValue = matrix[i];
            }
        }
        return maxValue;
    }

    public int getIndex1D(int value, int matrix[]) {
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i] == value) {
                return i;
            }
        return -1;
    }

    public int getIndex1D(double value, double matrix[]) {
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i] == value) {
                return i;
            }
        return -1;
    }

    public int getIndexOfRow2D(int value, int matrix[][]) {
        for (int i = 0; i < matrix[0].length; i++)
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == value) {
                    return i;
                }
            }
        return -1;
    }

    public void print(int[] matrix){
        for (int el: matrix) {
            System.out.print(el + "  ");
        }
        System.out.println();
    }

    public void print(double[] matrix){
        for (double el: matrix) {
            System.out.print(el + "  ");
        }
        System.out.println();
    }

    public void print(int[][] matrix){
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
