package com.shymoniak.model.lab5;

import com.shymoniak.tools.MatrixActions;

import java.util.Arrays;

public class MatrixGames {
    // Визначити ціну матричної гри (нижню і верхню границю), перевірити наявність сідлової точки
    public int isSolutionSaddlePoint(int[][] arr) {
        MatrixActions matrixActions = new MatrixActions();
        int[] minInRows = matrixActions.getMinInRows2D(arr);
        int[] maxInCols = matrixActions.getMaxInCols2D(arr);
        int maxMin = Arrays.stream(minInRows).max().orElse(0);
        int minMax = Arrays.stream(maxInCols).min().orElse(0);
        System.out.println("Minmax = " + minMax + ", Maxmin = " + maxMin);
        if (minMax == maxMin) {
            return minMax;
        } else {
            return -1;
        }
    }

    // Видалення домінованих рядків
    public int[][] checkDominationRows(int[][] arr) {
        boolean isDominating;
        boolean tempBoolean;
        for (int i = 0; i < arr.length - 1; i++) {
            isDominating = arr[i][0] > arr[i + 1][0];
            for (int k = 0; i + k < arr.length; k++) {
                for (int j = 0; j < arr[0].length - 1; j++) {
                    if (arr[i][j] > arr[i + k][j]) {  // якщо кожен елемент в рядку більший за елемент іншого рядка
                        tempBoolean = true;
                    } else {
                        tempBoolean = false;
                    }
                    isDominating = isDominating && tempBoolean;
                }
                System.out.println("Is dominating row: " + i + "-" + (i + k) + " " + isDominating);
                if (isDominating) {
                    MatrixActions matrixActions = new MatrixActions();
                    arr = matrixActions.deleteMatrixRow(arr, i);
                    checkDominationRows(arr);
                }
            }
            System.out.println();
        }
        return arr;
    }

    // Видалення домінованих стовпців
    public int[][] checkDominationCols(int[][] arr) {
        boolean isDominating;
        boolean tempBoolean;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j + i < arr[0].length; j++) {
                isDominating = true;
                for (int k = 0; k < arr[0].length; k++) {
                    if (arr[k][i] > arr[k][i + j]) {
                        tempBoolean = true;
                    } else {
                        tempBoolean = false;
                    }
                    isDominating = isDominating && tempBoolean;
                }
                System.out.println("Is dominating col: " + i + "-" + (i + j) + " " + isDominating);
                if (isDominating) {
                    MatrixActions matrixActions = new MatrixActions();
                    arr = matrixActions.deleteMatrixCol(arr, i + j);
                    checkDominationCols(arr);
                }
            }
            System.out.println();
        }
        return arr;
    }
}