package com.shymoniak.controller;

import com.shymoniak.model.lab1.HurwitzCriterion;
import com.shymoniak.model.lab1.LaplaceCriterion;
import com.shymoniak.model.lab1.WaldCriterion;
import com.shymoniak.tools.*;

import java.io.File;
import java.util.Arrays;

/**
 * Компанія має три альтернативних варіанти своєї стратегії розвитку. Оцінка його
 * прибутку в залежності від стану зовнішнього середовища наведено в таблиці.
 * А) Прийняти рішення в умовах невизначеності.
 * Необхідно знайти оптимальні стратегії при песимістичній оцінці (по критерію
 * Вальда), оцінці Лапласа, по критерію Гурвіца. Значення коефіцієнта оптимізму
 * вибрати самостійно. Результати вибору рішення відобразити в таблиці. Зробити
 * висновки по застосуванню критеріїв
 * <p>
 * Матриця цінностей [№ варіанту 1 (29-28=1)]
 * 100 80 50
 * 90 90 70
 * 60 70 80
 */
public class TaskAL1 {

    public void run() {
        TxtFileReader txtFileReader = new TxtFileReader();
        int[][] taskMatrix = txtFileReader.read2DArrayInt(
                new File(Constants.LAB1_FILE_DIR), 3, 3);
        System.out.println("    Task A\n" + Arrays.deepToString(taskMatrix));

        // Wald criterion
        WaldCriterion waldCriterion = new WaldCriterion(taskMatrix);
        System.out.println("\n--- Wald criterion: ---");
        int[] waldSolution = waldCriterion.bestSolution();
        System.out.print("The best solution is: "
                + Arrays.toString(waldSolution) + "\n");

        // Laplace criterion
        LaplaceCriterion laplaceCriterion = new LaplaceCriterion(taskMatrix);
        System.out.println("\n--- Laplace criterion: ---");
        int[] laplaceSolution = laplaceCriterion.bestSolution();
        System.out.print("The best solution is: "
                + Arrays.toString(laplaceSolution) + "\n");

        // Hurwitz criterion, coefficient = 0.7
        HurwitzCriterion hurwitzCriterion = new HurwitzCriterion(taskMatrix, 0.7);
        System.out.println("\n--- Hurwitz criterion: ---");
        System.out.println("Coefficient = 0.7");
        int[] hurwitzSolution1 = hurwitzCriterion.bestSolution();
        System.out.print("The best solution is: "
                + Arrays.toString(hurwitzSolution1) + "\n");

        // Hurwitz criterion, coefficient = 0.3
        hurwitzCriterion = new HurwitzCriterion(taskMatrix, 0.3);
        System.out.println("\nCoefficient = 0.3");
        int[] hurwitzSolution2 = hurwitzCriterion.bestSolution();
        System.out.print("The best solution is: "
                + Arrays.toString(hurwitzSolution2));
    }
}