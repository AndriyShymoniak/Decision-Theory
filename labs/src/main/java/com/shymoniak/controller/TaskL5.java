package com.shymoniak.controller;

import com.shymoniak.model.lab5.*;
import com.shymoniak.model.lab5.gauss.*;
import com.shymoniak.tools.Constants;
import com.shymoniak.tools.TxtFileReader;

import java.io.File;
import java.util.Arrays;

public class TaskL5 {
    public void run() {
        TxtFileReader txtFileReader = new TxtFileReader();
        int[][] matrix = txtFileReader.read2DArrayInt(
                            new File(Constants.LAB5_FILE_DIR), 5, 5);
        System.out.println(Arrays.toString(matrix));

        MatrixGames matrixGames = new MatrixGames();
        if (matrixGames.isSolutionSaddlePoint(matrix) != -1) {
            System.out.println("Saddle point"
                    + matrixGames.isSolutionSaddlePoint(matrix));
        } else {
            System.out.println("There is no saddle point");
            System.out.println("Mixed strategy applying:");

            // Перевірка на домінуючі рядки, та їх видалення
            matrix = matrixGames.checkDominationRows(matrix);
            matrix = matrixGames.checkDominationCols(matrix);

            int[][] player1Matrix = matrix;
            int[][] player2Matrix = transposeMatrix(matrix);

            // Додавання необхідних елементів перед використання методу Гауса
            player1Matrix = addAdditionalMatrixRow(player1Matrix);
            player2Matrix = addAdditionalMatrixRow(player2Matrix);

            // Метод Гауса
            System.out.println("\nPlayer А strategy");
            launchGaussMethod(player1Matrix);
            System.out.println("\nPlayer B strategy");
            launchGaussMethod(player2Matrix);
        }
    }

    private void launchGaussMethod(int[][] matrix) {
        LinearSystem<Float, MyEquation> list = generateSystem(matrix);
        printSystem(list);
        int i, j;
        Algorithm<Float, MyEquation> alg = new Algorithm<>(list);
        try {
            alg.calculate();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        Float[] x = new Float[matrix.length];
        for (i = list.size() - 1; i >= 0; i--) {
            Float sum = 0.0f;
            for (j = list.size() - 1; j > i; j--) {
                sum += list.itemAt(i, j) * x[j];
            }
            x[i] = (list.itemAt(i, list.size()) - sum) / list.itemAt(i, j);
        }
        printSystem(list);
        printVector(x);
    }

    private static LinearSystem<Float, MyEquation> generateSystem(int[][] arr) {
        LinearSystem<Float, MyEquation> list = new LinearSystem<Float, MyEquation>();
        for (int i = 0; i < arr.length; i++) {
            MyEquation equation = new MyEquation();
            equation.generate(arr[i]);
            list.push(equation);
        }
        return list;
    }

    private static void printSystem(LinearSystem<Float, MyEquation> system) {
        for (int i = 0; i < system.size(); i++) {
            MyEquation temp = system.get(i);
            String s = "";
            for (int j = 0; j < temp.size(); j++) {
                s += String.format("%f; %s", system.itemAt(i, j), "\t");
            }
            System.out.println(s);
        }
        System.out.println("");
    }

    private static void printVector(Float[] x) {
        String s = "";
        for (int i = 0; i < x.length; i++) {
            s += String.format("x%d = %f; ", i, x[i]);
        }
        System.out.println(s);
    }

    /* Додаємо додаткове значення х5 до кожного рядка з коефіцієнтом -1,
        прирівнюємо кожне рівняння до 0
        x1 + x2 +...+ xn - y = 0
        Додаємо додатковий рядок  x1 + x2 +...+ xn + 0y = 1
    */
    private int[][] addAdditionalMatrixRow(int[][] arr) {
        int[][] newArr = new int[arr.length + 1][arr[0].length + 2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            newArr[i][newArr[0].length - 2] = -1;
            newArr[i][newArr[0].length - 1] = 0;
        }
        for (int i = 0; i < arr[0].length; i++) {
            newArr[newArr.length - 1][i] = 1;
        }
        newArr[newArr.length - 1][newArr.length - 1] = 0;
        newArr[newArr.length - 1][newArr.length] = 1;
        return newArr;
    }

    public static int[][] transposeMatrix(int [][] m){
        int[][] temp = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }
}