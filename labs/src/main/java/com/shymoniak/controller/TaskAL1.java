package com.shymoniak.controller;

import com.shymoniak.model.lab1.criterias.*;
import com.shymoniak.tools.*;

import java.io.File;
import java.util.Arrays;

/**
 * Компанія має три альтернативних варіанти своєї стратегії розвитку. Оцінка його
 * прибутку в залежності від стану зовнішнього середовища наведено в таблиці.
 * <p>
 * А) Прийняти рішення в умовах невизначеності.
 * Необхідно знайти оптимальні стратегії при песимістичній оцінці (по критерію Вальда),
 * оцінці Лапласа, по критерію Гурвіца. Значення коефіцієнта оптимізму вибрати
 * самостійно. Результати вибору рішення відобразити в таблиці. Зробити висновки по
 * застосуванню критеріїв
 * <p>
 * Матриця цінностей
 * № варіанту 1 (29-28=1)
 * <p>
 * 100 80 50
 * 90 90 70
 * 60 70 80
 */
public class TaskAL1 {

    public void run() {
        TxtFileReader txtFileReader = new TxtFileReader();
        MatrixActions matrixActions = new MatrixActions();

        int[][] taskMatrix = txtFileReader.readTwoDimensionalArrayInt(new File(Constants.LAB1_FILE_DIRECTORY), 3, 3);
        System.out.println("    Task A\n");
        System.out.println(Arrays.toString(taskMatrix));

        WaldCriteria waldCriteria = new WaldCriteria(taskMatrix);
        System.out.println("Wald criteria:");
        int[] waldSolution = waldCriteria.bestSolution();
        System.out.print("The best solution is: ");
        System.out.println(Arrays.toString(waldSolution));
        System.out.println();

        LaplaceCriterion laplaceCriterion = new LaplaceCriterion(taskMatrix);
        System.out.println("Laplace criterion:");
        int[] laplaceSolution = laplaceCriterion.bestSolution();
        System.out.print("The best solution is: ");
        System.out.println(Arrays.toString(laplaceSolution));
        System.out.println();

        HurwitzCriteria hurwitzCriteria = new HurwitzCriteria(taskMatrix, 0.7);
        System.out.println("Hurwitz criteria:");
        System.out.println("Coefficient = 0.7");
        int[] hurwitzSolution1 = hurwitzCriteria.bestSolution();
        System.out.print("The best solution is: ");
        System.out.println(Arrays.toString(hurwitzSolution1));

        System.out.println();
        hurwitzCriteria = new HurwitzCriteria(taskMatrix, 0.3);
        System.out.println("Coefficient = 0.3");
        int[] hurwitzSolution2 = hurwitzCriteria.bestSolution();
        System.out.print("The best solution is: ");
        System.out.println(Arrays.toString(hurwitzSolution2));
        System.out.println("__________________________________\n");
    }
}
