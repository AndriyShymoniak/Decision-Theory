package com.shymoniak.lab5;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskL5Test {
    int[][] arr = {{10, 5, 10, 3, 9},
            {7, 4, 2, 6, 10},
            {3, 2, 9, 5, 2},
            {4, 3, 2, 8, 6},
            {4, 3, 5, 10, 3}};

    @Test
    public void isSolutionSaddlePointMatrix() {
        int[] minInRows = new int[arr.length];
        int[] minInCols = new int[arr[0].length];
        int temp;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i][0];
            for (int j = 0; j < arr[0].length; j++) {
                if (temp > arr[i][j]) {
                    temp = arr[i][j];
                }
            }
            minInRows[i] = temp;

        }
        int[] expected = {3, 2, 2, 2, 3};
        Assert.assertArrayEquals(expected, minInRows);

        for (int i = 0; i < arr[0].length; i++) {
            temp = arr[0][i];
            for (int j = 0; j < arr.length; j++) {
                if (temp < arr[j][i]) {
                    temp = arr[j][i];
                }
            }
            minInCols[i] = temp;
        }
        int[] expected1 = {10, 10, 10, 10, 10};
        Assert.assertArrayEquals(expected1, minInCols);
    }

    @Test
    public void isDominatingRow() {
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
            }
            System.out.println();
        }
    }

    @Test
    public void isDominatingCol() {
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
                    System.out.println("Is dominating row: " + arr[k][i] + ">" + arr[k][i + j] + isDominating);
                }
                System.out.println();
            }
        }
    }

    @Test
    public void deleteRow() {
        int rowIndex = 1;
        int[][] newArr = new int[arr.length - 1][arr[0].length];
        int[][] expected = {{10, 5, 10, 3, 9},
                {3, 7, 9, 5, 2},
                {4, 9, 2, 8, 6},
                {4, 10, 5, 10, 3}};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i < rowIndex) {
                    newArr[i][j] = arr[i][j];
                } else {
                    newArr[i][j] = arr[i + 1][j];
                }
            }
        }
        Assert.assertArrayEquals(expected, newArr);
    }

    @Test
    public void deleteCol() {
        int colIndex = 1;
        int[][] newArr = new int[arr.length][arr[0].length - 1];
        int[][] expected = {{10, 10, 3, 9},
                {7, 2, 6, 10},
                {3, 9, 5, 2},
                {4, 2, 8, 6},
                {4, 5, 10, 3}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (j < colIndex) {
                    newArr[i][j] = arr[i][j];
                } else {
                    newArr[i][j] = arr[i][j + 1];
                }
            }
        }
        Assert.assertArrayEquals(expected, newArr);
    }
}