package com.shymoniak.tools;

import java.util.Arrays;

public class MatrixActions {

    public int findLowestIn1D(int[] matrix) {
        return Arrays.stream(matrix)
                    .min()
                    .getAsInt();
    }

    public int findHighestIn1D(int[] matrix) {
        return Arrays.stream(matrix)
                    .max()
                    .getAsInt();
    }

    public double findHighestIn1D(double[] matrix) {
        return Arrays.stream(matrix)
                    .max()
                    .getAsDouble();
    }

    public int getIndexIn1D(int value, int matrix[]) {
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i] == value) {
                return i;
            }
        return -1;
    }

    public int getIndexIn1D(double value, double matrix[]) {
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i] == value) {
                return i;
            }
        return -1;
    }

    public int getIndexOfRowIn2D(int value, int matrix[][]) {
        for (int i = 0; i < matrix[0].length; i++)
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == value) {
                    return i;
                }
            }
        return -1;
    }

    public int[][] deleteMatrixRow(int[][] arr, int rowNum) {
        int[][] resultArr = new int[arr.length - 1][arr[0].length];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i < rowNum) {
                    resultArr[i][j] = arr[i][j];
                } else {
                    resultArr[i][j] = arr[i + 1][j];
                }
            }
        }
        return resultArr;
    }

    public int[][] deleteMatrixCol(int[][] arr, int colNum) {
        int[][] resultArr = new int[arr.length][arr[0].length - 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (j < colNum) {
                    resultArr[i][j] = arr[i][j];
                } else {
                    resultArr[i][j] = arr[i][j + 1];
                }
            }
        }
        return resultArr;
    }
}