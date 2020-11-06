package com.shymoniak.lab5;

import com.shymoniak.lab5.gauss.Algorithm;
import com.shymoniak.lab5.gauss.LinearSystem;
import com.shymoniak.lab5.gauss.MyEquation;
import com.shymoniak.tools.Constants;
import com.shymoniak.tools.FileWorker;
import com.shymoniak.tools.MatrixActions;

import java.io.File;
import java.util.Arrays;

public class TaskL5 {
    public void run() {
        FileWorker fileWorker = new FileWorker();
        MatrixActions matrixActions = new MatrixActions();
        int[][] matrix = fileWorker.readTwoDimensionalArrayInt(new File(Constants.LAB5_FILE_DIRECTORY), 5, 5);
        matrixActions.print(matrix);

        MatrixGames matrixGames = new MatrixGames();
        if (matrixGames.isSolutionSaddlePoint(matrix) != -1) {
            System.out.println("Saddle point" + matrixGames.isSolutionSaddlePoint(matrix));
        } else {
            System.out.println("Mixed strategy");
            matrix = matrixGames.checkDominationRows(matrix);
            matrix = matrixGames.checkDominationCols(matrix);
            matrix = addAdditionalMatrixRow(matrix);

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

    }

    private static LinearSystem<Float, MyEquation> generateSystem(int[][] arr) {
        LinearSystem<Float, MyEquation> list = new LinearSystem<Float, MyEquation>();
        int i;
        for (i = 0; i < arr.length; i++) {
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

    // Додаємо додаткове значення х5 до кожного рядка з коефіцієнтом -1, прирівнюєм кожне рівняння до 0
    // x1 + x2 +...+ xn - y = 0
    // Додаємо додатковий рядок  x1 + x2 +...+ xn + 0y = 1
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
}