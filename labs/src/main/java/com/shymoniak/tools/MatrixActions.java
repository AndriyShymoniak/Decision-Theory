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

    public int[] getMinInRows2D(int[][] arr){
        int temp;
        int[] minInRows = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i][0];
            for (int j = 0; j < arr[0].length; j++) {
                if (temp > arr[i][j]) {
                    temp = arr[i][j];
                }
            }
            minInRows[i] = temp;
        }
        return minInRows;
    }

    public int[] getMaxInCols2D(int[][] arr){
        int[] maxInCols = new int[arr[0].length];
        int temp;
        for (int i = 0; i < arr[0].length; i++) {
            temp = arr[0][i];
            for (int j = 0; j < arr.length; j++) {
                if (temp < arr[j][i]) {
                    temp = arr[j][i];
                }
            }
            maxInCols[i] = temp;
        }
        return maxInCols;
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